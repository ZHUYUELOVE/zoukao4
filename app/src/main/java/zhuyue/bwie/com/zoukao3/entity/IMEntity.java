package zhuyue.bwie.com.zoukao3.entity;

import java.util.List;

public class IMEntity {
    public List<Result> result;
    public String message;
    public String status;

    public class Result{
        public String followMovie;
        public int id;
        public String imageUrl;
        public String name;
        public int rank;
        public String summary;
    }

}
