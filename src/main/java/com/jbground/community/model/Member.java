package com.jbground.community.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table(name = "Member")
public class Member {

    @Id
    private String id;

    @Column
    private String password;
    
    @Column
    private String name;

    @Column
    private LocalDateTime register_date;

    @Column
    private String nickname;

    @Column
    private String phone;

    @Column
    private String sex;

    @Column
    private String birth;

    @Column
    private String email;

    @Column
    private String rank;

    @Column
    private String ip;

    @Column
    private LocalDateTime login_date;

    @Column
    private LocalDateTime change_date;

    @Column
    private int address_seq;
  

    public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDateTime getRegister_date() {
		return register_date;
	}

	public void setRegister_date(LocalDateTime register_date) {
		this.register_date = register_date;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getBirth() {
		return birth;
	}

	public void setBirth(String birth) {
		this.birth = birth;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getRank() {
		return rank;
	}

	public void setRank(String rank) {
		this.rank = rank;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public LocalDateTime getLogin_date() {
		return login_date;
	}

	public void setLogin_date(LocalDateTime login_date) {
		this.login_date = login_date;
	}

	public LocalDateTime getChange_date() {
		return change_date;
	}

	public void setChange_date(LocalDateTime change_date) {
		this.change_date = change_date;
	}

	public int getAddress_seq() {
		return address_seq;
	}

	public void setAddress_seq(int address_seq) {
		this.address_seq = address_seq;
	}

	@Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Member{");
        sb.append("id='").append(id).append('\'');
        sb.append(", password='").append(password).append('\'');
        sb.append(", register_date=").append(register_date);
        sb.append(", nickname='").append(nickname).append('\'');
        sb.append(", phone='").append(phone).append('\'');
        sb.append(", sex='").append(sex).append('\'');
        sb.append(", birth='").append(birth).append('\'');
        sb.append(", email='").append(email).append('\'');
        sb.append(", rank='").append(rank).append('\'');
        sb.append(", ip='").append(ip).append('\'');
        sb.append(", login_date=").append(login_date);
        sb.append(", change_date=").append(change_date);
        sb.append(", address_seq=").append(address_seq);
        sb.append('}');
        return sb.toString();
    }
}
