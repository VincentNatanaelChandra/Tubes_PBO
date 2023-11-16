/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author Devid L Manurung
 */
public class Refund {
    private int refund_id;
    private RefundEnum refund_status;

    public Refund(int refund_id, RefundEnum refund_status) {
        this.refund_id = refund_id;
        this.refund_status = refund_status;
    }

    public int getRefund_id() {
        return refund_id;
    }

    public void setRefund_id(int refund_id) {
        this.refund_id = refund_id;
    }

    public RefundEnum getRefund_status() {
        return refund_status;
    }

    public void setRefund_status(RefundEnum refund_status) {
        this.refund_status = refund_status;
    }
}
