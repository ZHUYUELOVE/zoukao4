package zhuyue.bwie.com.zoukao3.callback;

import java.util.HashMap;

import io.reactivex.Observable;
import okhttp3.ResponseBody;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.QueryMap;
import retrofit2.http.Url;

public interface IRetrofitService {
    @GET
    Observable<ResponseBody> getReg(@Url String apiurl, @QueryMap HashMap<String,String> params);
    @POST
    Observable<ResponseBody> postReg(@Url String apiurl,@QueryMap HashMap<String,String> params);

}
