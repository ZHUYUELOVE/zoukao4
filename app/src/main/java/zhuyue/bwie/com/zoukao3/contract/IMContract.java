package zhuyue.bwie.com.zoukao3.contract;

import java.util.HashMap;
import java.util.List;

import zhuyue.bwie.com.zoukao3.callback.IRequestCallback;
import zhuyue.bwie.com.zoukao3.entity.IMEntity;

public interface IMContract {

    abstract class IMPresenter{
        public abstract void getIM(HashMap<String,String> params);
    }
    interface IMModel{
        void getIM(HashMap<String,String> params, IRequestCallback iRequestCallback);
    }
    interface IMView{
        void onSuccess(List<IMEntity.Result> result);
        void onFailed(String error);

    }

}
