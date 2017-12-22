package com.geyan.model;

import java.util.Date;

public class User implements java.io.Serializable {
	
    /**
	 * 
	 */
	private static final long serialVersionUID = 2028044343222645745L;

	private String id;

    private String username;

    private String email;

    private String password;

    private String status;

    private String realname;

    private String sex;

    private Date birthday;

    private String homeAddress;

    private String qq;

    private String msn;

    private String mobileNumber;

    private String idCard;

    private String currentAddress;

    private String nickname;

    private String securityQuestion1;

    private String securityQuestion2;

    private String securityAnswer1;

    private String securityAnswer2;

    private Date lastLoginTime;

    private Date registerTime;

    private String area;

    private String cashPassword;

    private String areaCity;

    private String photo;

    private String recommender;

    private Integer score;

    private Date disableTime;

    private Date becomecoordinationertime;

    private Date pipsAcctDate;

    private String pipsAcctNo;

    private String borrowerInfoId;

    private String level;

    private String bindIp;

    private String referrer;

    private Boolean hasGivenCoupon;

    private String hdcode;

    private String signuserid;
    
    /**
	 * 电子签章证书地址[上上签]
	 */
	private String signerCert;
	/**
	 * 电子签章图片地址
	 */
	private String signImage;

    private Integer personarea;

    private String idHvps;
    
    private String busiCode;
    
    private String source;
    
    private String isLonner;//判断是否是借款人,如果为空是投资人，如果为1是借款人
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname == null ? null : realname.trim();
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getHomeAddress() {
        return homeAddress;
    }

    public void setHomeAddress(String homeAddress) {
        this.homeAddress = homeAddress == null ? null : homeAddress.trim();
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq == null ? null : qq.trim();
    }

    public String getMsn() {
        return msn;
    }

    public void setMsn(String msn) {
        this.msn = msn == null ? null : msn.trim();
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber == null ? null : mobileNumber.trim();
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard == null ? null : idCard.trim();
    }

    public String getCurrentAddress() {
        return currentAddress;
    }

    public void setCurrentAddress(String currentAddress) {
        this.currentAddress = currentAddress == null ? null : currentAddress.trim();
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname == null ? null : nickname.trim();
    }

    public String getSecurityQuestion1() {
        return securityQuestion1;
    }

    public void setSecurityQuestion1(String securityQuestion1) {
        this.securityQuestion1 = securityQuestion1 == null ? null : securityQuestion1.trim();
    }

    public String getSecurityQuestion2() {
        return securityQuestion2;
    }

    public void setSecurityQuestion2(String securityQuestion2) {
        this.securityQuestion2 = securityQuestion2 == null ? null : securityQuestion2.trim();
    }

    public String getSecurityAnswer1() {
        return securityAnswer1;
    }

    public void setSecurityAnswer1(String securityAnswer1) {
        this.securityAnswer1 = securityAnswer1 == null ? null : securityAnswer1.trim();
    }

    public String getSecurityAnswer2() {
        return securityAnswer2;
    }

    public void setSecurityAnswer2(String securityAnswer2) {
        this.securityAnswer2 = securityAnswer2 == null ? null : securityAnswer2.trim();
    }

    public Date getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(Date lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    public Date getRegisterTime() {
        return registerTime;
    }

    public void setRegisterTime(Date registerTime) {
        this.registerTime = registerTime;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area == null ? null : area.trim();
    }

    public String getCashPassword() {
        return cashPassword;
    }

    public void setCashPassword(String cashPassword) {
        this.cashPassword = cashPassword == null ? null : cashPassword.trim();
    }

    public String getAreaCity() {
        return areaCity;
    }

    public void setAreaCity(String areaCity) {
        this.areaCity = areaCity == null ? null : areaCity.trim();
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo == null ? null : photo.trim();
    }

    public String getRecommender() {
        return recommender;
    }

    public void setRecommender(String recommender) {
        this.recommender = recommender == null ? null : recommender.trim();
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public Date getDisableTime() {
        return disableTime;
    }

    public void setDisableTime(Date disableTime) {
        this.disableTime = disableTime;
    }

    public Date getBecomecoordinationertime() {
        return becomecoordinationertime;
    }

    public void setBecomecoordinationertime(Date becomecoordinationertime) {
        this.becomecoordinationertime = becomecoordinationertime;
    }

    public Date getPipsAcctDate() {
        return pipsAcctDate;
    }

    public void setPipsAcctDate(Date pipsAcctDate) {
        this.pipsAcctDate = pipsAcctDate;
    }

    public String getPipsAcctNo() {
        return pipsAcctNo;
    }

    public void setPipsAcctNo(String pipsAcctNo) {
        this.pipsAcctNo = pipsAcctNo == null ? null : pipsAcctNo.trim();
    }

    public String getBorrowerInfoId() {
        return borrowerInfoId;
    }

    public void setBorrowerInfoId(String borrowerInfoId) {
        this.borrowerInfoId = borrowerInfoId == null ? null : borrowerInfoId.trim();
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level == null ? null : level.trim();
    }

    public String getBindIp() {
        return bindIp;
    }

    public void setBindIp(String bindIp) {
        this.bindIp = bindIp == null ? null : bindIp.trim();
    }

    public String getReferrer() {
        return referrer;
    }

    public void setReferrer(String referrer) {
        this.referrer = referrer == null ? null : referrer.trim();
    }

    public Boolean getHasGivenCoupon() {
        return hasGivenCoupon;
    }

    public void setHasGivenCoupon(Boolean hasGivenCoupon) {
        this.hasGivenCoupon = hasGivenCoupon;
    }

    public String getHdcode() {
        return hdcode;
    }

    public void setHdcode(String hdcode) {
        this.hdcode = hdcode == null ? null : hdcode.trim();
    }

    public String getSignuserid() {
        return signuserid;
    }

    public void setSignuserid(String signuserid) {
        this.signuserid = signuserid == null ? null : signuserid.trim();
    }

    public String getSignerCert() {
		return signerCert;
	}

	public void setSignerCert(String signerCert) {
		this.signerCert = signerCert;
	}

	public String getSignImage() {
		return signImage;
	}

	public void setSignImage(String signImage) {
		this.signImage = signImage;
	}

	public Integer getPersonarea() {
        return personarea;
    }

    public void setPersonarea(Integer personarea) {
        this.personarea = personarea;
    }

    public String getIdHvps() {
        return idHvps;
    }

    public void setIdHvps(String idHvps) {
        this.idHvps = idHvps == null ? null : idHvps.trim();
    }

	public String getBusiCode() {
		return busiCode;
	}

	public void setBusiCode(String busiCode) {
		this.busiCode = busiCode;
	}
	
	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getIsLonner() {
		return isLonner;
	}

	public void setIsLonner(String isLonner) {
		this.isLonner = isLonner;
	}
    
}