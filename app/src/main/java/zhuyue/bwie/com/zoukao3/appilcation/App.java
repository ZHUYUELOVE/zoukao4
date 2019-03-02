package zhuyue.bwie.com.zoukao3.appilcation;

import android.app.Application;
import android.os.Environment;

import com.facebook.cache.disk.DiskCacheConfig;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.imagepipeline.core.ImagePipelineConfig;

public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        initFresco();
    }

    private void initFresco() {
      //设置磁盘缓存
        DiskCacheConfig cacheConfig = DiskCacheConfig.newBuilder(this)
                .setBaseDirectoryName("fimages")
                .setBaseDirectoryPath(Environment.getExternalStorageDirectory())
                .build();
        //设置磁盘缓存的配置，生成配置文件
        ImagePipelineConfig config = ImagePipelineConfig.newBuilder(this)
                .setMainDiskCacheConfig(cacheConfig)
                .build();
        Fresco.initialize(this,config);


    }
}
