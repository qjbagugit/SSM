package com.ssm.po;

public class Orderdetail {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column orderdetail.id
     *
     * @mbg.generated
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column orderdetail.orders_id
     *
     * @mbg.generated
     */
    private Integer ordersId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column orderdetail.items_id
     *
     * @mbg.generated
     */
    private Integer itemsId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column orderdetail.items_num
     *
     * @mbg.generated
     */
    private Integer itemsNum;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column orderdetail.id
     *
     * @return the value of orderdetail.id
     *
     * @mbg.generated
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column orderdetail.id
     *
     * @param id the value for orderdetail.id
     *
     * @mbg.generated
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column orderdetail.orders_id
     *
     * @return the value of orderdetail.orders_id
     *
     * @mbg.generated
     */
    public Integer getOrdersId() {
        return ordersId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column orderdetail.orders_id
     *
     * @param ordersId the value for orderdetail.orders_id
     *
     * @mbg.generated
     */
    public void setOrdersId(Integer ordersId) {
        this.ordersId = ordersId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column orderdetail.items_id
     *
     * @return the value of orderdetail.items_id
     *
     * @mbg.generated
     */
    public Integer getItemsId() {
        return itemsId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column orderdetail.items_id
     *
     * @param itemsId the value for orderdetail.items_id
     *
     * @mbg.generated
     */
    public void setItemsId(Integer itemsId) {
        this.itemsId = itemsId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column orderdetail.items_num
     *
     * @return the value of orderdetail.items_num
     *
     * @mbg.generated
     */
    public Integer getItemsNum() {
        return itemsNum;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column orderdetail.items_num
     *
     * @param itemsNum the value for orderdetail.items_num
     *
     * @mbg.generated
     */
    public void setItemsNum(Integer itemsNum) {
        this.itemsNum = itemsNum;
    }
}