package demo1;

import java.sql.Timestamp;
import java.util.Date;

public class SaleRedPacket {

    private int paId;
    private int saleOrgId;
    private int status;
    private String configJson;
    private Date updateTime;
    private double minBalance;
    private double minServFee;
    private double percent;

    private Timestamp time;

    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }

    public int getPaId() {
        return paId;
    }

    public void setPaId(int paId) {
        this.paId = paId;
    }

    public int getSaleOrgId() {
        return saleOrgId;
    }

    public void setSaleOrgId(int saleOrgId) {
        this.saleOrgId = saleOrgId;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getConfigJson() {
        return configJson;
    }

    public void setConfigJson(String configJson) {
        this.configJson = configJson;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public double getMinBalance() {
        return minBalance;
    }

    public void setMinBalance(double minBalance) {
        this.minBalance = minBalance;
    }

    public double getMinServFee() {
        return minServFee;
    }

    public void setMinServFee(double minServFee) {
        this.minServFee = minServFee;
    }

    public double getPercent() {
        return percent;
    }

    public void setPercent(double percent) {
        this.percent = percent;
    }

    @Override
    public String toString() {
        return "SaleRedPacket{" +
                "paId=" + paId +
                ", saleOrgId=" + saleOrgId +
                ", status=" + status +
                ", configJson='" + configJson + '\'' +
                ", updateTime=" + updateTime +
                ", minBalance=" + minBalance +
                ", minServFee=" + minServFee +
                ", percent=" + percent +
//                ", time=" + time +
                '}';
    }
}
