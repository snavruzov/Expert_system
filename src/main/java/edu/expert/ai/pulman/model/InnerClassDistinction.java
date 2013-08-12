package edu.expert.ai.pulman.model;

import edu.expert.ai.pulman.api.constants.AI;
import edu.expert.ai.pulman.beans.PulmanMarks;
import edu.expert.ai.pulman.dao.ContentDAO;

import java.util.LinkedHashMap;
import java.util.LinkedList;

/**
 * Created by Intellij IDEA.
 * User: Sardor Navruzov
 * Date: 7/17/13
 * Time: 3:44 PM
 */
public class InnerClassDistinction extends ClassDistinctionImpl
{

    private Integer beta_up;
    private Integer beta_down;
    private static Double[][] beta;

    public InnerClassDistinction()
    {
    }

    public InnerClassDistinction(LinkedHashMap<Integer, Integer> grd,LinkedHashMap<Integer,Integer> cGrd,
                                 ContentDAO dao)
    {
        beta = new Double[AI.CLAZZ_CNT+1][grd.size()+cGrd.size()+2];
        System.out.println();
        calculate(grd, dao);
    }


    private void calculate(LinkedHashMap<Integer, Integer> grd, ContentDAO dao)
    {
        LinkedList<Integer> GT = new LinkedList<>();

        Integer ct = 0;
        //Integer patientCount = dao.getPulmanPatientTableCount().intValue();
        Integer sumJ = 0;
        //Определение внутриклассового сходства признаков...
        for (int d = 1; d <= AI.CLAZZ_CNT; d++)
        {
            for (Integer c : grd.keySet())
            {
                ct=1;
                GT.clear();
                for (int gr = 1; gr <= dao.getPulmanNominalTableCount(c); gr++)
                {
                    if(GDCT(c, gr, d, dao)!=0)
                    {
                        GT.add(ct++);
                    }

                }

                for(Integer t:GT)
                {
                    int gdct = GDCT(c,t,d,dao);
                    sumJ+=(gdct*(gdct-1));
                    //System.out.println("sum: "+sumJ+" GT: "+GT+" gdct: "+gdct+" c: "+c+"");
                    //System.exit(1);
                }

                int thetadc = thetaDC(d,c,dao)-LDC(d,c,dao);
                //System.out.println("thetadc: "+thetadc+" thetaDC("+d+","+c+",dao): " +
                        //""+thetaDC(d,c,dao)+" LDC(d,c,dao): "+LDC(d,c,dao)+" SUMJ: "+sumJ);
                this.beta_up = sumJ;
                this.beta_down = (thetadc+1)*(thetadc);
                try{
                beta[d][c] = (this.beta_up.doubleValue()/this.beta_down.doubleValue());
                } catch (Exception e)
                {
                    System.out.println("K size: "+AI.CLAZZ_CNT+" grd.size(): "+grd.size()+" c,d: "+c+","+d);
                    e.printStackTrace();
                    System.exit(1);
                }
                sumJ = 0;
            }

        }

    }

    public static Double[][] BETA()
    {
        return beta;
    }

}
