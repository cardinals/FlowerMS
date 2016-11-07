package cn.coselding.flowerms.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by 宇强 on 2016/7/13 0013.
 */
public class Order {

    private static final SimpleDateFormat FORMAT = new SimpleDateFormat("yyyy-MM-dd hh:mm");

    private int orderID;
    private Date orderDate;
    private String orderDateShow;
    private Date sendTime;//
    private String sendTimeShow;//
    private String receiveName;//
    private String receiveTel;//
    private String receiveAdd;//
    private short payState;//
    private int salesman;//
    private String workername;//
    private short sendState;//
    private String remarks;//
    private short status;//
    private int flowerID;
    private int quantity;
    private String sendName;//

    public String getWorkername() {
        return workername;
    }

    public void setWorkername(String workername) {
        this.workername = workername;
    }

    public String getOrderDateShow() {
        return orderDateShow;
    }

    public void setOrderDateShow(String orderDateShow) {
        this.orderDateShow = orderDateShow.replace("T"," ");
        try {
            this.orderDate=FORMAT.parse(this.orderDateShow);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    public String getSendTimeShow() {
        return sendTimeShow;
    }

    public void setSendTimeShow(String sendTimeShow) {
        this.sendTimeShow = sendTimeShow.replace("T"," ");
        try {
            this.sendTime=FORMAT.parse(this.sendTimeShow);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderID=" + orderID +
                ", orderDate=" + orderDate +
                ", sendTime=" + sendTime +
                ", receiveName='" + receiveName + '\'' +
                ", receiveTel='" + receiveTel + '\'' +
                ", receiveAdd='" + receiveAdd + '\'' +
                ", payState=" + payState +
                ", salesman=" + salesman +
                ", sendState=" + sendState +
                ", remarks='" + remarks + '\'' +
                ", status=" + status +
                ", flowerID=" + flowerID +
                ", quantity=" + quantity +
                ", sendName='" + sendName + '\'' +
                '}';
    }

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
        if(orderDate!=null) {
            this.orderDateShow = FORMAT.format(orderDate).replace(" ", "T");
        }
    }

    public Date getSendTime() {
        return sendTime;
    }

    public void setSendTime(Date sendTime) {
        this.sendTime = sendTime;
        if(sendTime!=null) {
            this.sendTimeShow = FORMAT.format(sendTime).replace(" ", "T");
        }
    }

    public String getReceiveName() {
        return receiveName;
    }

    public void setReceiveName(String receiveName) {
        this.receiveName = receiveName;
    }

    public String getReceiveTel() {
        return receiveTel;
    }

    public void setReceiveTel(String receiveTel) {
        this.receiveTel = receiveTel;
    }

    public String getReceiveAdd() {
        return receiveAdd;
    }

    public void setReceiveAdd(String receiveAdd) {
        this.receiveAdd = receiveAdd;
    }

    public short getPayState() {
        return payState;
    }

    public void setPayState(short payState) {
        this.payState = payState;
    }

    public int getSalesman() {
        return salesman;
    }

    public void setSalesman(int salesman) {
        this.salesman = salesman;
    }

    public short getSendState() {
        return sendState;
    }

    public void setSendState(short sendState) {
        this.sendState = sendState;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public short getStatus() {
        return status;
    }

    public void setStatus(short status) {
        this.status = status;
    }

    public int getFlowerID() {
        return flowerID;
    }

    public void setFlowerID(int flowerID) {
        this.flowerID = flowerID;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getSendName() {
        return sendName;
    }

    public void setSendName(String sendName) {
        this.sendName = sendName;
    }
}
