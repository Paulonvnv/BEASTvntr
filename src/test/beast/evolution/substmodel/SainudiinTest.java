package test.beast.evolution.substmodel;

import beast.core.Description;
import beast.core.parameter.RealParameter;
import beast.evolution.substitutionmodel.Frequencies;
import beast.evolution.substitutionmodel.Sainudiin;
import junit.framework.TestCase;


@Description("Test Sainudiin matrix exponentiation")
public class SainudiinTest extends TestCase {

    public interface Instance {
        Double[] getPi();

        Double getRb();
        Double getIeq();
        Double getG();
        Double getA1();
        Double getNrOfStates();

        double getDistance();

        double[] getExpectedResult();
    }


    protected Instance test0 = new Instance() {
        @Override
		public Double[] getPi() {
            return new Double[]{0.066666667,0.066666667,0.066666667,0.066666667,0.066666667,0.066666667,0.066666667,0.066666667,0.066666667,0.066666667,0.066666667,0.066666667,0.066666667,0.066666667,0.066666667};
        }

        @Override
		public Double getRb() {
            return 0.5;
        }
        @Override
        public Double getIeq() {
            return 5.5;
        }
        @Override
        public Double getG() {
            return 0.1;
        }
        @Override
        public Double getA1() {
            return 1.0;
        }
        @Override
        public Double getNrOfStates() {
            return 15.0;
        }

        @Override
		public double getDistance() {
            return 0.5;
        }

        @Override
		public double[] getExpectedResult() {
            return new double[]{
                0.7690374610084049,0.1608491184135012,0.04764075831132215,0.01514176041632971,0.004936499041555592,0.001618620193017408,0.0005279545138609927,0.0001701065114635176,0.00005387226369656343,0.00001670751854968103,0.000005059475594548908,0.000001492943413487646,0.0000004293301230055837,0.0000001218109175889775,0.00000003824825037512383,0.2326624655152488,0.4526579068684243,0.1929872363601616,0.07634804659467380,0.02895754116421173,0.01063287073335075,0.003790584117517192,0.001312672507598718,0.0004413990559914069,0.0001440126747458272,0.00004555031339227818,0.00001395866132362970,0.000004150132214826254,0.000001213593541750374,0.0000003917076033148330,0.08120119059712835,0.2093908532853961,0.3475217542269206,0.2006576930988195,0.09489464041337370,0.04058390583563512,0.01622409165603598,0.006150356092943692,0.002226653659916527,0.0007727518498849878,0.0002576063870285610,0.00008260916072649117,0.00002556071318904860,0.000007749141451027298,0.000002583881550763949,0.02955418816600891,0.09166672647347948,0.2097463146438996,0.2890215157299049,0.1948600233715350,0.1035400890776882,0.04823649476970814,0.02054027805569882,0.008157091566773836,0.003054313197498937,0.001085292620414509,0.0003675668462739036,0.0001192842658647765,0.00003774688077828567,0.00001307433447313836,0.01104727599985895,0.03914342206820212,0.1087841023423436,0.2075979996280798,0.2530633851931742,0.1843214714952060,0.1054916734406387,0.05214316597207925,0.02322970848138601,0.009539115766828338,0.003658264771363299,0.001321535728684764,0.0004534898112375373,0.0001508332082114040,0.00005455609270613028,0.004238687236726322,0.01663860374286264,0.05304596845235759,0.1238520359646803,0.2043920991391185,0.2287481647163586,0.1723263956513492,0.1031071689996237,0.05297086425245393,0.02432291853230844,0.01021307515917880,0.003979219109259222,0.001456864382128717,0.0005131085233078703,0.0001948261382867161,0.001669407831487649,0.007113967541567208,0.02519009116987771,0.06794362498272466,0.1368361903410616,0.2009384852457848,0.2105496615193432,0.1599364811487487,0.09791960459121329,0.05144657348595287,0.02405215951611296,0.01023686446612367,0.004039376238734571,0.001518856938346875,0.0006086549829207666,0.0006746472990064117,0.003076482636086971,0.01184974823910529,0.03572233140382969,0.08327005910044727,0.1479817109464783,0.1972352333802938,0.1954487355844034,0.1473871929707202,0.09091110971741598,0.04824030086179769,0.02275855287812724,0.009790990196112813,0.003966284167795551,0.001686620618380144,0.0002795489880310924,0.001349710688841736,0.005573463512771176,0.01837989170729688,0.04803479767596004,0.09863076225369106,0.1573303295974726,0.1929238719088279,0.1817128212006796,0.1346887634225436,0.08278491325100051,0.04400275398527331,0.02090970651769087,0.009217055334241695,0.004181609955678093,0.0001186588461812507,0.0006016409077916926,0.002635175393183939,0.009364362136699972,0.02686332528692931,0.06188131193902494,0.1135922171561277,0.1647266501284333,0.1875833535075324,0.1683957554503564,0.1219614226662369,0.07426186677249198,0.03953075650819894,0.01916226505680748,0.009321238244003075,0.00005154119987740544,0.0002726753582471095,0.001256477815930988,0.004758261920220912,0.01475937152954201,0.03738062609962393,0.07690175091502469,0.1276686828089812,0.1699725768831227,0.1810231529159216,0.1553116299455503,0.1098051296772354,0.06637937126730267,0.03574426046365296,0.01871449119976542,0.00002288889796939149,0.0001256968471553835,0.0006054616130088399,0.002422826552326947,0.008036066964654025,0.02205460731717834,0.04991146977784643,0.09269637063869540,0.1405450075064471,0.1732883051653904,0.1738602694077251,0.1433480338007382,0.09938591180716218,0.05989473899829900,0.03380234470540296,0.00001039614375782142,0.00005901974515334967,0.0002956951660872738,0.001242264935695702,0.004369555304681221,0.01285853017577883,0.03158947919771559,0.06456913908739426,0.1093687098571801,0.1529482155302157,0.1762962049646426,0.1679630128564003,0.1335872909167551,0.09015382629673878,0.05468865982180245,0.000004871752132712243,0.00002850829149815690,0.0001480412899160936,0.0006500400306434728,0.002410957367793118,0.007552785361501202,0.01995959448793146,0.04439108689329357,0.08282615645744354,0.1291943599403022,0.1679279849521506,0.1815008368383903,0.1630458651061480,0.1217447533909045,0.07861415783994977,0.000002544408844399404,0.00001530846632332176,0.00008213156720919005,0.0003752813161150009,0.001459049660528331,0.004827269957716194,0.01357719451607952,0.03239179538290730,0.06533479057440868,0.1109355690158992,0.1577374665176448,0.1866579167365459,0.1824721293799512,0.1459155226249075,0.09821602987491784};
        }
    };

    Instance[] all = {test0};

    public void testSainudiin() throws Exception {
        for (Instance test : all) {

            RealParameter f = new RealParameter(test.getPi());

            Frequencies freqs = new Frequencies();
            freqs.initByName("frequencies", f, "estimate", false);


            Sainudiin sainudiin = new Sainudiin();
            sainudiin.setNrOfStates(15);
            sainudiin.initByName("rb", test.getRb().toString(),
                "ieq", test.getIeq().toString(), 
                "g", test.getG().toString(), 
                "a1", test.getA1().toString(), 
                "frequencies", freqs);

            double distance = test.getDistance();

            double[] mat = new double[15 * 15];
            sainudiin.getTransitionProbabilities(null, distance, 0, 1, mat);
            final double[] result = test.getExpectedResult();

            for (int k = 0; k < mat.length; ++k) {
                assertEquals(mat[k], result[k], 1e-12);
                System.out.println(k + " : " + (mat[k] - result[k]));
            }
        }
    }
}