package edu.expert.ai.pulman.beans;

import javax.persistence.*;

@Entity
@Table(name = "authorities")
public class Authority
{
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "authority")
    private String authority;

    public Authority()
    {

    }

    public Authority(Long id, String authority)
    {
        setId(id);
        setAuthority(authority);
    }

    public Authority(String id)
    {
        setId(Long.parseLong(id));
    }

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public String getAuthority()
    {
        return authority;
    }

    public void setAuthority(String authority)
    {
        this.authority = authority;
    }
}