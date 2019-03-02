package zhuyue.bwie.com.zoukao3.presenter;

import com.google.gson.Gson;

import java.util.HashMap;

import zhuyue.bwie.com.zoukao3.callback.IRequestCallback;
import zhuyue.bwie.com.zoukao3.contract.IMContract;
import zhuyue.bwie.com.zoukao3.entity.IMEntity;
import zhuyue.bwie.com.zoukao3.model.IMModel;

public class IMPresenter extends IMContract.IMPresenter {

    private IMContract.IMView imView;
    private IMModel imModel;

    public IMPresenter(IMContract.IMView imView) {
        this.imView = imView;
        imModel=new IMModel();
    }

    @Override
    public void getIM(HashMap<String, String> params) {
        imModel.getIM(params, new IRequestCallback() {
            @Override
            public void onSuccess(String result) {
                IMEntity imEntity = new Gson().fromJson(result, IMEntity.class);
                if (imView!=null){
                    imView.onSuccess(imEntity.result);
                }
            }

            @Override
            public void onFailed(String error) {
                if (imView!=null){
                    imView.onFailed(error);
                }
            }
        });

    }

}
