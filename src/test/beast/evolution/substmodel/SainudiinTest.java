package test.beast.evolution.substmodel;

import beast.core.Description;
import beast.core.parameter.RealParameter;
import beast.evolution.substitutionmodel.Frequencies;
import beast.evolution.substitutionmodel.Sainudiin;
import junit.framework.TestCase;
import beast.evolution.substitutionmodel.EigenDecomposition;


@Description("Test Sainudiin matrix exponentiation")
public class SainudiinTest extends TestCase {

	public interface Instance {
		Double[] getPi();

		Double getBiasMagnitude();
		Double getFocalPoint();
		Double getG();
		Double getOneOnA1();

		double getDistance();

		double[] getExpectedResult();

		double getDistanceStepWise();

		double[] getExpectedResultStepWise();
		double[] getExpectedResultStationaryDistribtion();
	}

	protected Instance test0 = new Instance() {
		@Override
		public Double[] getPi() {
			return new Double[]{0.066666667,0.066666667,0.066666667,0.066666667,0.066666667,0.066666667,0.066666667,0.066666667,0.066666667,0.066666667,0.066666667,0.066666667,0.066666667,0.066666667,0.066666667};
		}

		@Override
		public Double getBiasMagnitude() {
			return 0.5;
		}
		@Override
		public Double getFocalPoint() {
			return 5.5;
		}
		@Override
		public Double getG() {
			return 0.1;
		}
		@Override
		public Double getOneOnA1() {
			return 1.0;
		}
		
		@Override
		public double getDistance() {
			return 0.5*5.098426256228357;
		}
		// The expected result is an unnormalized matrix Q from Mathematica
		@Override
		public double[] getExpectedResult() {
			return new double[]{
				0.7690374610084049,0.1608491184135012,0.04764075831132215,0.01514176041632971,0.004936499041555592,0.001618620193017408,0.0005279545138609927,0.0001701065114635176,0.00005387226369656343,0.00001670751854968103,0.000005059475594548908,0.000001492943413487646,0.0000004293301230055837,0.0000001218109175889775,0.00000003824825037512383,0.2326624655152488,0.4526579068684243,0.1929872363601616,0.07634804659467380,0.02895754116421173,0.01063287073335075,0.003790584117517192,0.001312672507598718,0.0004413990559914069,0.0001440126747458272,0.00004555031339227818,0.00001395866132362970,0.000004150132214826254,0.000001213593541750374,0.0000003917076033148330,0.08120119059712835,0.2093908532853961,0.3475217542269206,0.2006576930988195,0.09489464041337370,0.04058390583563512,0.01622409165603598,0.006150356092943692,0.002226653659916527,0.0007727518498849878,0.0002576063870285610,0.00008260916072649117,0.00002556071318904860,0.000007749141451027298,0.000002583881550763949,0.02955418816600891,0.09166672647347948,0.2097463146438996,0.2890215157299049,0.1948600233715350,0.1035400890776882,0.04823649476970814,0.02054027805569882,0.008157091566773836,0.003054313197498937,0.001085292620414509,0.0003675668462739036,0.0001192842658647765,0.00003774688077828567,0.00001307433447313836,0.01104727599985895,0.03914342206820212,0.1087841023423436,0.2075979996280798,0.2530633851931742,0.1843214714952060,0.1054916734406387,0.05214316597207925,0.02322970848138601,0.009539115766828338,0.003658264771363299,0.001321535728684764,0.0004534898112375373,0.0001508332082114040,0.00005455609270613028,0.004238687236726322,0.01663860374286264,0.05304596845235759,0.1238520359646803,0.2043920991391185,0.2287481647163586,0.1723263956513492,0.1031071689996237,0.05297086425245393,0.02432291853230844,0.01021307515917880,0.003979219109259222,0.001456864382128717,0.0005131085233078703,0.0001948261382867161,0.001669407831487649,0.007113967541567208,0.02519009116987771,0.06794362498272466,0.1368361903410616,0.2009384852457848,0.2105496615193432,0.1599364811487487,0.09791960459121329,0.05144657348595287,0.02405215951611296,0.01023686446612367,0.004039376238734571,0.001518856938346875,0.0006086549829207666,0.0006746472990064117,0.003076482636086971,0.01184974823910529,0.03572233140382969,0.08327005910044727,0.1479817109464783,0.1972352333802938,0.1954487355844034,0.1473871929707202,0.09091110971741598,0.04824030086179769,0.02275855287812724,0.009790990196112813,0.003966284167795551,0.001686620618380144,0.0002795489880310924,0.001349710688841736,0.005573463512771176,0.01837989170729688,0.04803479767596004,0.09863076225369106,0.1573303295974726,0.1929238719088279,0.1817128212006796,0.1346887634225436,0.08278491325100051,0.04400275398527331,0.02090970651769087,0.009217055334241695,0.004181609955678093,0.0001186588461812507,0.0006016409077916926,0.002635175393183939,0.009364362136699972,0.02686332528692931,0.06188131193902494,0.1135922171561277,0.1647266501284333,0.1875833535075324,0.1683957554503564,0.1219614226662369,0.07426186677249198,0.03953075650819894,0.01916226505680748,0.009321238244003075,0.00005154119987740544,0.0002726753582471095,0.001256477815930988,0.004758261920220912,0.01475937152954201,0.03738062609962393,0.07690175091502469,0.1276686828089812,0.1699725768831227,0.1810231529159216,0.1553116299455503,0.1098051296772354,0.06637937126730267,0.03574426046365296,0.01871449119976542,0.00002288889796939149,0.0001256968471553835,0.0006054616130088399,0.002422826552326947,0.008036066964654025,0.02205460731717834,0.04991146977784643,0.09269637063869540,0.1405450075064471,0.1732883051653904,0.1738602694077251,0.1433480338007382,0.09938591180716218,0.05989473899829900,0.03380234470540296,0.00001039614375782142,0.00005901974515334967,0.0002956951660872738,0.001242264935695702,0.004369555304681221,0.01285853017577883,0.03158947919771559,0.06456913908739426,0.1093687098571801,0.1529482155302157,0.1762962049646426,0.1679630128564003,0.1335872909167551,0.09015382629673878,0.05468865982180245,0.000004871752132712243,0.00002850829149815690,0.0001480412899160936,0.0006500400306434728,0.002410957367793118,0.007552785361501202,0.01995959448793146,0.04439108689329357,0.08282615645744354,0.1291943599403022,0.1679279849521506,0.1815008368383903,0.1630458651061480,0.1217447533909045,0.07861415783994977,0.000002544408844399404,0.00001530846632332176,0.00008213156720919005,0.0003752813161150009,0.001459049660528331,0.004827269957716194,0.01357719451607952,0.03239179538290730,0.06533479057440868,0.1109355690158992,0.1577374665176448,0.1866579167365459,0.1824721293799512,0.1459155226249075,0.09821602987491784};
		}
		// distance = time * normalization (of Q)
		@Override
		public double getDistanceStepWise() {
			return 0.5 * 4.761921891506542;
		}

		@Override
		public double[] getExpectedResultStepWise() {
			return new double[]{
				0.7712049992483787,0.1759604269828351,0.04092504261836892,0.009312941840182765,0.002051533507945971,0.0004352545496527480,0.00008863030759412366,0.00001727340180607383,0.000003213987907003114,0.0000005695974383211285,0.00000009593638266511984,0.00000001532365083440207,0.000000002316646695334811,0.0000000003319912433624663,0.00000000004921772737197820,0.2272447768976175,0.4636292434471643,0.2096080635277464,0.07127620686167149,0.02093536375204695,0.005556393950186245,0.001358875355274594,0.0003091971786838771,0.00006578609006764018,0.00001312127443312079,0.000002456091633101345,0.0000004315682342865693,0.00000007117600139733390,0.00000001105678316975782,0.000000001772454808729872,0.05587513613611588,0.2215942754420773,0.3670761705462551,0.2186300631252086,0.09200147262917793,0.03181460497786169,0.009591473441968489,0.002594506476237526,0.0006396446640125788,0.0001450399216073987,0.00003041323383831671,0.000005916694055087359,0.000001070167144012726,0.0000001810418918644231,0.00000003150254762089582,0.01304101706902055,0.07728411700725064,0.2242358250191124,0.3126310518655922,0.2127801317288866,0.1022835636660033,0.03956577542621765,0.01307308291709952,0.003808356299343366,0.0009963153368207896,0.0002367423400448510,0.00005146491661003311,0.00001028655733989805,0.000001907592429234989,0.0000003622582292803659,0.003014786177797317,0.02382207069023709,0.09902462940494197,0.2232977780251542,0.2783005239019112,0.2015789970349093,0.1051709982837211,0.04387781012869796,0.01546155434032488,0.004748534435309429,0.001295795498103925,0.0003181110467470318,0.00007087076063080167,0.00001451444948567987,0.000003025822028583017,0.0007032760905483536,0.006951790254967252,0.03765126869411847,0.1180222287682859,0.2216409039479736,0.2543705666231931,0.1885293411120837,0.1031191630602223,0.04515720488953460,0.01660975410975539,0.005285308880836024,0.001482976523829698,0.0003718664998212325,0.00008481779280324242,0.00001953275202750067,0.0001670750422369150,0.001983490124483079,0.01324296397787253,0.05326285380834577,0.1349110177656928,0.2199508979640977,0.2358240667379358,0.1747609030656828,0.09780402618048203,0.04403476610826765,0.01661880095310389,0.005401446049017918,0.001541263399999970,0.0003952233961620854,0.0001012054266189678,0.00004061399947447477,0.0005629301413678285,0.004468103128456427,0.02195084921591384,0.07020449620591665,0.1500564713064925,0.2179780888562102,0.2198596747989620,0.1605571505207630,0.09034290681626939,0.04115604606243102,0.01572018471173025,0.005166110773164273,0.001505004311621415,0.0004313691512259183,0.00001012631257842894,0.0001604952794027661,0.001476102167895956,0.008568801673522565,0.03314990904216871,0.08805451101353773,0.1634686593495798,0.2151487658792387,0.2048196956444251,0.1459636720790051,0.08152307188749618,0.03712440373824557,0.01423102304732605,0.004763226123065098,0.001537536762512759,0.000002592246081513834,0.00004623866804785675,0.0004834664053579956,0.003238026825302883,0.01470584181949070,0.04678308629954430,0.1063101106259031,0.1748655973822682,0.2108365441896663,0.1897260748526036,0.1310574378014351,0.07202089317487244,0.03260878654348553,0.01268271172274648,0.004632591443194976,0.0000006814357771747482,0.00001350850398205747,0.0001582248670802346,0.001200861594912632,0.006263255931695119,0.02323429140881739,0.06261984026968484,0.1243304064968308,0.1837871053501529,0.2045479193654454,0.1741858311637959,0.1162700108797230,0.06283303944229576,0.02867815983522926,0.01187686345457862,0.0000001838838100128274,0.000004010068709909600,0.00005200330016723601,0.0004410298117047943,0.002597658738608603,0.01101369355847393,0.03438444079028923,0.08023077869848545,0.1413948665858002,0.1899028794398267,0.1964297965536556,0.1589537303051065,0.1030983863562561,0.05551059042509061,0.02598595148401591,0.00000005090739416866229,0.000001211088121182276,0.00001722436501876210,0.0001614234183723446,0.001059766664325733,0.005057379965102260,0.01796671188762422,0.04828218235633397,0.09925447407083855,0.1574517528554992,0.1943871432464728,0.1887955193657015,0.1464854422782652,0.09260882740346012,0.04847089012747066,0.00000001449624851871765,0.0000003738340768916560,0.000005790000780950907,0.00005948260974194535,0.0004312723988595270,0.002292099308996134,0.009154662112097955,0.02794916629490820,0.06601203258416376,0.1216838434845818,0.1762944683631358,0.2019870830710117,0.1840180062691724,0.1336096311451839,0.07650207402704097,0.000000004637713606671072,0.0000001293238538241847,0.000002174195500411999,0.00002437676424634017,0.0001940206027305466,0.001139103727538541,0.005058908759129300,0.01728755482179885,0.04598336907571229,0.09591757078428124,0.1575587552077093,0.2040514790346388,0.2078463029328076,0.1650922103734093,0.09984403975893036};
		}

		@Override
		public double[] getExpectedResultStationaryDistribtion() {
			return new double[]{
			   0.19065711,0.12877908,0.11435306,0.10634927,0.09821227,0.087937400,0.075374914,0.061382671,0.047266394,0.034306577,0.023420854,0.015018162,0.009036781,0.0050976913,0.0028077555};
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
			sainudiin.setMinRepeat(0);
			sainudiin.initByName("biasMagnitude", test.getBiasMagnitude().toString(),
				"focalPoint", test.getFocalPoint().toString(), 
				"g", test.getG().toString(), 
				"oneOnA1", test.getOneOnA1().toString(),
				"frequencies", freqs);

			double distance = test.getDistance();

			double[] mat = new double[15 * 15];
			sainudiin.getTransitionProbabilities(null, distance, 0, 1, mat);
			final double[] result = test.getExpectedResult();

			for (int k = 0; k < mat.length; ++k) {
				assertEquals(mat[k], result[k], 1e-8);
				System.out.println(k + " : " + (mat[k] - result[k]));
			}

			// The case fore g=0.0 should be the same as stepwise.
			Sainudiin sainudiinstepwise = new Sainudiin();
			sainudiinstepwise.setNrOfStates(15);
			sainudiinstepwise.setMinRepeat(0);
			sainudiinstepwise.initByName("biasMagnitude", test.getBiasMagnitude().toString(),
				"focalPoint", test.getFocalPoint().toString(), 
				"g", "0.0", 
				"oneOnA1", test.getOneOnA1().toString(),
				"frequencies", freqs);

			double distanceStepWise = test.getDistanceStepWise();

			mat = new double[15 * 15];
			sainudiinstepwise.getTransitionProbabilities(null, distanceStepWise, 0, 1, mat);
			final double[] resultStepWise = test.getExpectedResultStepWise();

			for (int k = 0; k < mat.length; ++k) {
				assertEquals(mat[k], resultStepWise[k], 1e-8);
				System.out.println(k + " : " + (mat[k] - resultStepWise[k]));
			}

			final double[] resultStationaryDistribution = test.getExpectedResultStationaryDistribtion();

			EigenDecomposition eigenDecomposition = sainudiin.getEigenDecomposition(null);
			double[] Eval = eigenDecomposition.getEigenValues();
			double[] Ievc = eigenDecomposition.getInverseEigenVectors();

			double[] stationaryDistribution = sainudiin.findStationaryDistribution(Eval, Ievc);

			for (int k = 0; k < 15; ++k) {
				assertEquals(stationaryDistribution[k], resultStationaryDistribution[k], 1e-8);
				System.out.println(k + " : " + (stationaryDistribution[k] - resultStationaryDistribution[k]));
			}
		}
	}
}