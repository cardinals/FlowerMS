package cn.coselding.flowerms.utils;

/**
 * Created by 宇强 on 2016/7/14 0014.
 */
public class Global {

    public enum PayState{
        YES((short) 1,"已付款"),NO((short) 0,"未付款");
        private short value;
        private String info;
        private PayState(short value, String info) {
            this.value = value;
            this.info = info;
        }

        public static PayState value(short value){
            for(PayState payState:values()){
                if(payState.value==value)
                    return payState;
            }
            return null;
        }

        public static short state(String info){
            for(PayState payState:values()){
                if(payState.info.equals(info))
                    return payState.value;
            }
            return -1;
        }
    }
    public enum SendState{
        YES((short) 1,"已发送"),NO((short) 0,"未发送");
        private short value;
        private String info;
        private SendState(short value, String info) {
            this.value = value;
            this.info = info;
        }

        public static SendState value(short value){
            for(SendState state:values()){
                if(state.value==value)
                    return state;
            }
            return null;
        }

        public static short state(String info){
            for(SendState state:values()){
                if(state.info.equals(info))
                    return state.value;
            }
            return -1;
        }
    }

    public enum Status{
        YES((short) 2,"已完成"),ING((short) 1,"正在进行中"),NO((short) 0,"已取消");
        private short value;
        private String info;
        private Status(short value, String info) {
            this.value = value;
            this.info = info;
        }

        public static Status value(short value){
            for(Status status:values()){
                if(status.value==value)
                    return status;
            }
            return null;
        }

        public static short state(String info){
            for(Status status:values()){
                if(status.info.equals(info))
                    return status.value;
            }
            return -1;
        }
    }

}
