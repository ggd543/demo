package bean.vo;

import java.io.Serializable;

/**
 * 税组
 *
 * @author 刘永健(liuyongjian@travelsky.com)
 * @since  2013/01/05
 */
public class Tax implements Serializable {
    /**
     * 货币种类
     */
    public String currency;
    /**
     * 金额
     */
    public double amount;
    /**
     * 税的种类
     */
    public String type;

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}