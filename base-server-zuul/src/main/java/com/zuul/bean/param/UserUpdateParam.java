package com.zuul.bean.param;

import java.io.Serializable;

/**
 * Created by mao_yejun on 2017/3/1.
 */
public class UserUpdateParam implements Serializable{
    private Long userId;
    private String companyName;
    private String contacts;
    private String contactsPhone;
    private String contactsMail;
    private String weChat;
    private String qq;
    private String companyWebAdd;
    private String loginId;
    private String password;
    private boolean allFlg;

    public boolean getAllFlg() {
        return allFlg;
    }

    public void setAllFlg(boolean allFlg) {
        this.allFlg = allFlg;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getContacts() {
        return contacts;
    }

    public void setContacts(String contacts) {
        this.contacts = contacts;
    }

    public String getContactsPhone() {
        return contactsPhone;
    }

    public void setContactsPhone(String contactsPhone) {
        this.contactsPhone = contactsPhone;
    }

    public String getContactsMail() {
        return contactsMail;
    }

    public void setContactsMail(String contactsMail) {
        this.contactsMail = contactsMail;
    }

    public String getWeChat() {
        return weChat;
    }

    public void setWeChat(String weChat) {
        this.weChat = weChat;
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    public String getCompanyWebAdd() {
        return companyWebAdd;
    }

    public void setCompanyWebAdd(String companyWebAdd) {
        this.companyWebAdd = companyWebAdd;
    }

    public String getLoginId() {
        return loginId;
    }

    public void setLoginId(String loginId) {
        this.loginId = loginId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
