package cn.coselding.flowerms.model;

/**
 * Created by 宇强 on 2016/7/13 0013.
 */
public class Worker {
    private int workerID;
    private String workername;
    private short status;

    @Override
    public String toString() {
        return "Worker{" +
                "workerID=" + workerID +
                ", workername='" + workername + '\'' +
                ", status=" + status +
                '}';
    }

    public int getWorkerID() {
        return workerID;
    }

    public void setWorkerID(int workerID) {
        this.workerID = workerID;
    }

    public String getWorkername() {
        return workername;
    }

    public void setWorkername(String workername) {
        this.workername = workername;
    }

    public short getStatus() {
        return status;
    }

    public void setStatus(short status) {
        this.status = status;
    }
}
