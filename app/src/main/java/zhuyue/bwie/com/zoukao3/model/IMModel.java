package zhuyue.bwie.com.zoukao3.model;

import java.util.HashMap;

import zhuyue.bwie.com.zoukao3.api.GouApi;
import zhuyue.bwie.com.zoukao3.callback.IOkhttpCallback;
import zhuyue.bwie.com.zoukao3.callback.IRequestCallback;
import zhuyue.bwie.com.zoukao3.contract.IMContract;
import zhuyue.bwie.com.zoukao3.utils.RetrofitUtil;

public class IMModel implements IMContract.IMModel {
    @Override
    public void getIM(HashMap<String, String> params, final IRequestCallback iRequestCallback) {
        RetrofitUtil.getInstance().doget(GouApi.GOUWU_URL, params, new IOkhttpCallback() {
            @Override
            public void onSuccess(String result) {
                if (iRequestCallback!=null){
                    iRequestCallback.onSuccess(result);
                }
            }

            @Override
            public void onFailed(String error) {
             if (iRequestCallback!=null){
                 iRequestCallback.onFailed(error);
             }
            }
        });
    }
}
