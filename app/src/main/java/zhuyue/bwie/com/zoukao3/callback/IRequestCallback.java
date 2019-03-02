package zhuyue.bwie.com.zoukao3.callback;

public interface IRequestCallback {
    void onSuccess(String result);
    void onFailed(String error);
}
