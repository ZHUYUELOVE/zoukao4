package zhuyue.bwie.com.zoukao3.utils;

import android.annotation.SuppressLint;

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import okhttp3.OkHttpClient;
import okhttp3.ResponseBody;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import zhuyue.bwie.com.zoukao3.api.Api;
import zhuyue.bwie.com.zoukao3.callback.IOkhttpCallback;
import zhuyue.bwie.com.zoukao3.callback.IRetrofitService;


public class RetrofitUtil {

    private static RetrofitUtil instance;
    private final OkHttpClient okHttpClient;
    private final Retrofit retrofit;

    private RetrofitUtil() {
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        okHttpClient = new OkHttpClient.Builder()
                .addInterceptor(httpLoggingInterceptor)
                .writeTimeout(10, TimeUnit.SECONDS)
                .connectTimeout(10, TimeUnit.SECONDS)
                .connectTimeout(10, TimeUnit.SECONDS)
                .build();
        retrofit = new Retrofit.Builder()
                .baseUrl(Api.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
    }

    public static RetrofitUtil getInstance() {
       if (instance==null){
           synchronized (RetrofitUtil.class){
               if (instance==null){
                   instance=new RetrofitUtil();
               }
           }
       }

        return instance;
    }
    @SuppressLint("CheckResult")
    public void doget(String apiUrl, HashMap<String,String>params, final IOkhttpCallback iokHttpCallback){
        IRetrofitService retrofitService = retrofit.create(IRetrofitService.class);
        retrofitService.getReg(apiUrl,params)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<ResponseBody>() {
                    @Override
                    public void accept( ResponseBody responseBody) throws Exception {
                        String result = responseBody.string();
                        if (iokHttpCallback!=null){
                            iokHttpCallback.onSuccess(result);
                        }
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        if (iokHttpCallback!=null){
                            iokHttpCallback.onFailed(throwable+"网络错误");
                        }
                    }
                });

    }
}
