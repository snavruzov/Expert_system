package edu.expert.ai.pulman.beans;

import org.hibernate.annotations.CollectionOfElements;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "users")
public class User
{
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "username")
    private String userName;

    @Column(name = "password")
    private String password;

    @CollectionOfElements(fetch = FetchType.EAGER)
    @Fetch(FetchMode.SELECT)
    private List<Authority> authorities;

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public String getUserName()
    {
        return userName;
    }

    public void setUserName(String userName)
    {
        this.userName = userName;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public List<Authority> getAuthorities()
    {
        return authorities;
    }

    public void setAuthorities(List<Authority> authorities)
    {
        this.authorities = authorities;
    }

    @Override
    public String toString()
    {
        String auth = "";

        for (Authority authority : getAuthorities())
        {
            auth += String.format("%s=%s,", authority.getId(), authority.getAuthority());
        }

        return String.format("User[name: %s, password:%s, auth:%s]", getUserName(), getPassword(), auth);
    }

}
