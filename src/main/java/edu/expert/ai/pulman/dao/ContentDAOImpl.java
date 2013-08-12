package edu.expert.ai.pulman.dao;

import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.Session;

import java.io.File;
import java.math.BigInteger;
import java.util.*;


public class ContentDAOImpl extends HibernateManager implements ContentDAO
{

    @Override
    public Long getPulmanPatientTableCount()
    {

        Long list = 0L;
        Session session = getSession();
        try
        {
            session.beginTransaction();
            Query q = session.createSQLQuery("SELECT COUNT(*) as cnt FROM patients")
                    .addScalar("cnt", Hibernate.LONG);

            list = (Long)q.uniqueResult();

            session.getTransaction().commit();
        } catch (Exception e)
        {
            e.printStackTrace();
            session.getTransaction().rollback();

        } finally
        {
            session.close();
        }

        return list;
    }

    public Long getPulmanNeNullCLGradationValues(Integer alias, Integer clazz)
    {
        Long list = 0L;
        Session session = getSession();
        String query = "SELECT COUNT(id_symp) as cnt FROM PULMANS WHERE id_symp IS NOT NULL " +
                "AND id_alias=:alias AND id_class<>:clazz";
        try
        {
            session.beginTransaction();
            Query q = session.createSQLQuery(query).addScalar("cnt", Hibernate.LONG);
            q.setInteger("alias",alias);
            q.setInteger("clazz",clazz);

            list = (Long)q.uniqueResult();
            session.getTransaction().commit();

        } catch (Exception e)
        {
            e.printStackTrace();
            session.getTransaction().rollback();
        } finally
        {
            session.close();
        }

        return list;

    }

    @Override
    public Long getPulmanNeNullGradationValues(Integer alias, Integer clazz)
    {
        Long list = 0L;
        Session session = getSession();
        String query = "SELECT COUNT(id_symp) as cnt FROM PULMANS WHERE id_symp IS NOT NULL " +
                "AND id_alias=:alias AND id_class=:clazz";
        try
        {
            session.beginTransaction();
            Query q = session.createSQLQuery(query).addScalar("cnt", Hibernate.LONG);
            q.setInteger("alias",alias);
            q.setInteger("clazz",clazz);

            list = (Long)q.uniqueResult();
            session.getTransaction().commit();

        } catch (Exception e)
        {
            e.printStackTrace();
            session.getTransaction().rollback();
        } finally
        {
            session.close();
        }

        return list;

    }

    public Long getPulmanClazzTableCount(Integer clazz)
    {
        Long list = 0L;
        Session session = getSession();
        try
        {
            session.beginTransaction();
            Query q = session.createSQLQuery("SELECT COUNT(DISTINCT(idp)) as cnt FROM PULMANS " +
                    "WHERE id_class=:clazz GROUP BY id_class")
            .addScalar("cnt", Hibernate.LONG);
            q.setInteger("clazz",clazz);
            list = (Long)q.uniqueResult();

            session.getTransaction().commit();
        } catch (Exception e)
        {
            e.printStackTrace();
            session.getTransaction().rollback();
        } finally
        {
            session.close();
        }

        return list;
    }


    @Override
    public Long getPulmanNominalTableCount(Integer alias)
    {
        Long list = 0L;
        Session session = getSession();
        try
        {
            session.beginTransaction();
            Query q = session.createSQLQuery("SELECT COUNT(*) as cnt FROM SYMPTOMS " +
                    "WHERE id_alias=:alias AND id_symp is not null ")
            .addScalar("cnt", Hibernate.LONG);
            q.setInteger("alias",alias);

            list = (Long)q.uniqueResult();

            session.getTransaction().commit();
        } catch (Exception e)
        {
            e.printStackTrace();
            session.getTransaction().rollback();
        } finally
        {
            session.close();
        }

        return list;
    }


    @Override
    public Long getPulmanGradationValuesByField(Integer alias, Integer symp,Integer clazz)
    {
        Long list = 0L;
        Session session = getSession();
        String query = "SELECT COUNT(id_symp) as cnt FROM PULMANS WHERE id_symp=:symp " +
                "AND id_alias=:alias AND id_class=:clazz";
        try
        {
            session.beginTransaction();
            Query q = session.createSQLQuery(query).addScalar("cnt", Hibernate.LONG);
            q.setInteger("symp",symp);
            q.setInteger("alias",alias);
            q.setInteger("clazz",clazz);

            list = (Long)q.uniqueResult();
            session.getTransaction().commit();

        } catch (Exception e)
        {
            e.printStackTrace();
            session.getTransaction().rollback();
        } finally
        {
            session.close();
        }
        return list;
    }

    @Override
    public Long getPulmanXorGradationValuesByField(Integer alias, Integer symp,Integer clazz)
    {
        Long list = 0L;
        Session session = getSession();
        String query = "SELECT COUNT(id_symp) as cnt FROM PULMANS WHERE id_symp=:symp " +
                "AND id_alias=:alias AND id_class<>:clazz";
        try
        {
            session.beginTransaction();
            Query q = session.createSQLQuery(query).addScalar("cnt",Hibernate.LONG);
            q.setInteger("symp",symp);
            q.setInteger("alias",alias);
            q.setInteger("clazz",clazz);

            list = (Long)q.uniqueResult();
            session.getTransaction().commit();

        } catch (Exception e)
        {
            e.printStackTrace();
            session.getTransaction().rollback();
        } finally
        {
            session.close();
        }

        return list;
    }

    @Override
    public Long getPulmanNullGradationValuesByField(Integer alias, Integer clazz)
    {
        Long list = 0L;
        Session session = getSession();
        String query = "SELECT COUNT(id_symp) as cnt FROM PULMANS WHERE id_symp is null " +
                "AND id_alias=:alias AND id_class<>:clazz";
        try
        {
            session.beginTransaction();
            Query q = session.createSQLQuery(query).addScalar("cnt",Hibernate.LONG);
            q.setInteger("alias",alias);
            q.setInteger("clazz",clazz);

            list = (Long)q.uniqueResult();
            session.getTransaction().commit();

        } catch (Exception e)
        {
            e.printStackTrace();
            session.getTransaction().rollback();
        } finally
        {
            session.close();
        }

        return list;
    }

/*
    public Long getPulmanLdcGradationValuesByField(Integer alias, Integer symp,Integer clazz)
    {
        Long list = 0L;
        Session session = getSession();
        String query ="SELECT COUNT(id_symp) as cnt FROM PULMANS WHERE id_symp=:symp " +
                "AND id_alias=:alias AND id_class=:clazz"
                "SELECT COUNT(*)SELECT ['+fld+'] FROM PULMAN WHERE ['+flklass+']='+inttostr(i1)+'AND ['+fld+']='+inttostr(l));
        try
        {
            session.beginTransaction();
            Query q = session.createSQLQuery(query).addScalar("cnt",Hibernate.LONG);
            q.setInteger("symp",symp);
            q.setInteger("alias",alias);
            q.setInteger("clazz",clazz);

            list = (Long)q.uniqueResult();
            session.getTransaction().commit();

        } catch (Exception e)
        {
            e.printStackTrace();
            session.getTransaction().rollback();
        } finally
        {
            session.close();
        }

        return list;
    }
*/

    @Override
    public LinkedHashMap<Integer,Map<Integer,Integer>> getPulmanMarks(Integer patientCount)
    {

        LinkedHashMap<Integer,Map<Integer,Integer>> retList = null;
        Map<Integer,Integer> aliases = null;
        Session session = getSession();
        try
        {
            session.beginTransaction();
            Query q = session.createSQLQuery("SELECT idp,id_symp,id_alias FROM PULMANS ORDER BY idp,id_alias");

            List<Object[]> list = q.list();
            if (!list.isEmpty())
            {
                retList = new LinkedHashMap<>();
                aliases = new HashMap<>();
                int pCount = 0;
                for (Object[] o : list)
                {
                    aliases.put((Integer)o[2],(Integer)o[1]);
                    retList.put((Integer)o[0],aliases);
                }
            }

            session.getTransaction().commit();
        } catch (Exception e)
        {
            e.printStackTrace();
            session.getTransaction().rollback();

        } finally
        {
            session.close();
        }

        return retList;
    }


    @Override
    public LinkedHashMap<Integer,Integer> getNominalGradationByCount()
    {

        LinkedHashMap<Integer,Integer> retList = null;
        Session session = getSession();
        try
        {
            session.beginTransaction();
            Query q = session.createSQLQuery("SELECT sm.id_alias, COUNT(sm.id_alias) as cnt FROM symptoms sm " +
                    " INNER JOIN aliases al ON al.id_alias=sm.id_alias AND al.type=1 " +
                    " GROUP BY sm.id_alias ORDER BY 1")
                    .addScalar("id_alias",Hibernate.INTEGER)
                    .addScalar("cnt",Hibernate.INTEGER);

            List<Object[]> list = q.list();

            if (!list.isEmpty())
            {
                retList = new LinkedHashMap<>();
                for (Object[] o : list)
                {
                    retList.put((Integer) o[0],(Integer) o[0]);
                }
            }

            session.getTransaction().commit();
        } catch (Exception e)
        {
            e.printStackTrace();
            session.getTransaction().rollback();

        } finally
        {
            session.close();
        }

        return retList;
    }

    @Override
    public LinkedHashMap<Integer,Integer> getCountableGradationByCount()
    {

        LinkedHashMap<Integer,Integer> retList = null;
        Session session = getSession();
        try
        {
            session.beginTransaction();
            Query q = session.createSQLQuery("SELECT sm.id_alias, COUNT(sm.id_alias) as cnt FROM symptoms sm " +
                    " INNER JOIN aliases al ON al.id_alias=sm.id_alias AND al.type=2 " +
                    " GROUP BY sm.id_alias ORDER BY 1")
                    .addScalar("id_alias",Hibernate.INTEGER)
                    .addScalar("cnt",Hibernate.INTEGER);

            List<Object[]> list = q.list();

            if (!list.isEmpty())
            {
                retList = new LinkedHashMap<>();
                for (Object[] o : list)
                {
                    retList.put((Integer) o[0],(Integer) o[0]);
                }
            }

            session.getTransaction().commit();
        } catch (Exception e)
        {
            e.printStackTrace();
            session.getTransaction().rollback();

        } finally
        {
            session.close();
        }

        return retList;
    }


}
