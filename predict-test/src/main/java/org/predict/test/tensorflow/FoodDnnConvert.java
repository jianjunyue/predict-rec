package org.predict.test.tensorflow;

import java.util.List;

import org.predict.data.Feature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FoodDnnConvert {
	private static final Logger log = LoggerFactory.getLogger(FoodDnnConvert.class); 
	    private float[] foodDnn = new float[192];

	    public float[] convert(List<Feature> featureTuples){
	        for (Feature featureTuple:featureTuples){
	            convertItem(featureTuple);

	        }
	        return this.foodDnn;

	    }

	    private float normalize(float value,float min, float max) {
	        if (value>=max) {
	            return 1.0f;
	        }else if (value<=min) {
	            return 0.0f;
	        }else{
	            return (value - min) / (max - min);
	        }


	    }
	    private float[] convertItem(Feature featureTuple) {
	        int index = featureTuple.getIndex();
	        float value = featureTuple.getValue();
	        switch (index) {
	            case 0:
	                foodDnn[0]=normalize(value,15.0f,50.0f);
	                break;
	            case 1:
	                foodDnn[1]=normalize(value,9.9f,19.9f);
	                break;
	            case 2:
	                foodDnn[2]=normalize(value,0.34f,0.66f);
	                break;
	            case 3:
	                foodDnn[3]=normalize(value,1.0f,1.0f);
	                break;
	            case 5:
	                foodDnn[4]=normalize(value,1.0f,1.0f);
	                break;
	            case 6:
	                foodDnn[5]=normalize(value,4.0f,336.0f);
	                break;
	            case 7:
	                foodDnn[6]=normalize(value,1.0f,1.0f);
	                break;
	            case 9:
	                foodDnn[7]=normalize(value,1.0f,2.0f);
	                break;
	            case 10:
	                foodDnn[8]=normalize(value,50.0f,443.0f);
	                break;
	            case 11:
	                foodDnn[9]=normalize(value,4.0f,332.0f);
	                break;
	            case 12:
	                foodDnn[10]=normalize(value,4.0f,331.0f);
	                break;
	            case 13:
	                foodDnn[11]=normalize(value,1.0f,1.0f);
	                break;
	            case 14:
	                foodDnn[12]=normalize(value,-1.0f,0.25f);
	                break;
	            case 15:
	                foodDnn[13]=normalize(value,0.33333334f,0.95652175f);
	                break;
	            case 16:
	                foodDnn[14]=normalize(value,1.0f,1.0f);
	                break;
	            case 17:
	                foodDnn[15]=normalize(value,-2.3333333f,-0.05882353f);
	                break;
	            case 18:
	                foodDnn[16]=normalize(value,1.0f,1.0f);
	                break;
	            case 19:
	                foodDnn[17]=normalize(value,1.0f,20.0f);
	                break;
	            case 20:
	                foodDnn[18]=normalize(value,2.0f,116.0f);
	                break;
	            case 21:
	                foodDnn[19]=normalize(value,60.0f,3503.27f);
	                break;
	            case 22:
	                foodDnn[20]=normalize(value,4.0f,336.0f);
	                break;
	            case 23:
	                foodDnn[21]=normalize(value,108.0f,10550.0f);
	                break;
	            case 25:
	                foodDnn[22]=normalize(value,88.0f,901.0f);
	                break;
	            case 26:
	                foodDnn[23]=normalize(value,78.0f,102.0f);
	                break;
	            case 27:
	                foodDnn[24]=normalize(value,78.16725f,102.403946f);
	                break;
	            case 28:
	                foodDnn[25]=normalize(value,1.0f,1.0f);
	                break;
	            case 29:
	                foodDnn[26]=normalize(value,1.0f,1.0f);
	                break;
	            case 31:
	                foodDnn[27]=normalize(value,1.0f,1.0f);
	                break;
	            case 32:
	                foodDnn[28]=normalize(value,1.0f,1.0f);
	                break;
	            case 33:
	                foodDnn[29]=normalize(value,1.0f,1.0f);
	                break;
	            case 34:
	                foodDnn[30]=normalize(value,2.0f,2.0f);
	                break;
	            case 35:
	                foodDnn[31]=normalize(value,65.45128f,100.0f);
	                break;
	            case 36:
	                foodDnn[32]=normalize(value,39.772762f,100.0f);
	                break;
	            case 37:
	                foodDnn[33]=normalize(value,84.892914f,98.76911f);
	                break;
	            case 38:
	                foodDnn[34]=normalize(value,54.4344f,100.0f);
	                break;
	            case 39:
	                foodDnn[35]=normalize(value,10.439364f,24.738094f);
	                break;
	            case 40:
	                foodDnn[36]=normalize(value,10.865397f,26.812847f);
	                break;
	            case 41:
	                foodDnn[37]=normalize(value,8.982452f,34.135853f);
	                break;
	            case 42:
	                foodDnn[38]=normalize(value,11.559823f,28.646357f);
	                break;
	            case 43:
	                foodDnn[39]=normalize(value,1.172203f,13.551665f);
	                break;
	            case 44:
	                foodDnn[40]=normalize(value,1.603675f,41.70354f);
	                break;
	            case 45:
	                foodDnn[41]=normalize(value,7.642051f,91.594246f);
	                break;
	            case 46:
	                foodDnn[42]=normalize(value,4.563778f,54.023605f);
	                break;
	            case 47:
	                foodDnn[43]=normalize(value,0.58331156f,88.44269f);
	                break;
	            case 48:
	                foodDnn[44]=normalize(value,13.32f,32.43f);
	                break;
	            case 49:
	                foodDnn[45]=normalize(value,12.944086f,74.20611f);
	                break;
	            case 50:
	                foodDnn[46]=normalize(value,12.443555f,74.99187f);
	                break;
	            case 51:
	                foodDnn[47]=normalize(value,10.155311f,75.94977f);
	                break;
	            case 52:
	                foodDnn[48]=normalize(value,12.229935f,72.62939f);
	                break;
	            case 53:
	                foodDnn[49]=normalize(value,1.0f,13.0f);
	                break;
	            case 54:
	                foodDnn[50]=normalize(value,1.0f,1.0f);
	                break;
	            case 55:
	                foodDnn[51]=normalize(value,63.714474f,100.0f);
	                break;
	            case 56:
	                foodDnn[52]=normalize(value,1.0f,1.0f);
	                break;
	            case 57:
	                foodDnn[53]=normalize(value,0.5f,0.81900454f);
	                break;
	            case 58:
	                foodDnn[54]=normalize(value,4.0f,4.0f);
	                break;
	            case 60:
	                foodDnn[55]=normalize(value,4.2445164f,4.938508f);
	                break;
	            case 61:
	                foodDnn[56]=normalize(value,9.0f,24.0f);
	                break;
	            case 62:
	                foodDnn[57]=normalize(value,0.1f,0.286179f);
	                break;
	            case 63:
	                foodDnn[58]=normalize(value,1.0f,1.0f);
	                break;
	            case 64:
	                foodDnn[59]=normalize(value,1.0f,1.0f);
	                break;
	            case 65:
	                foodDnn[60]=normalize(value,8.0f,242.0f);
	                break;
	            case 66:
	                foodDnn[61]=normalize(value,1.0f,1.0f);
	                break;
	            case 67:
	                foodDnn[62]=normalize(value,3.886877f,4.790722f);
	                break;
	            case 68:
	                foodDnn[63]=normalize(value,1.0f,1.0f);
	                break;
	            case 69:
	                foodDnn[64]=normalize(value,1.0f,4.0f);
	                break;
	            case 70:
	                foodDnn[65]=normalize(value,123.0f,2692.0f);
	                break;
	            case 71:
	                foodDnn[66]=normalize(value,1.0f,6.0f);
	                break;
	            case 72:
	                foodDnn[67]=normalize(value,1.0f,4.0f);
	                break;
	            case 73:
	                foodDnn[68]=normalize(value,1.0f,3.0f);
	                break;
	            case 74:
	                foodDnn[69]=normalize(value,1.0f,3.0f);
	                break;
	            case 75:
	                foodDnn[70]=normalize(value,1.0f,2.0f);
	                break;
	            case 76:
	                foodDnn[71]=normalize(value,1.0f,2.0f);
	                break;
	            case 77:
	                foodDnn[72]=normalize(value,4.0f,5.0f);
	                break;
	            case 78:
	                foodDnn[73]=normalize(value,4.0f,5.0f);
	                break;
	            case 79:
	                foodDnn[74]=normalize(value,4.0f,5.0f);
	                break;
	            case 80:
	                foodDnn[75]=normalize(value,1.0f,3.0f);
	                break;
	            case 81:
	                foodDnn[76]=normalize(value,4.0f,5.0f);
	                break;
	            case 82:
	                foodDnn[77]=normalize(value,4.0f,5.0f);
	                break;
	            case 85:
	                foodDnn[78]=normalize(value,1.0f,1.0f);
	                break;
	            case 89:
	                foodDnn[79]=normalize(value,5.0f,184.0f);
	                break;
	            case 90:
	                foodDnn[80]=normalize(value,1.0f,12.0f);
	                break;
	            case 91:
	                foodDnn[81]=normalize(value,11.0f,17.0f);
	                break;
	            case 92:
	                foodDnn[82]=normalize(value,1.0f,1.0f);
	                break;
	            case 93:
	                foodDnn[83]=normalize(value,0.025481602f,0.38914028f);
	                break;
	            case 95:
	                foodDnn[84]=normalize(value,10.5f,36.0f);
	                break;
	            case 96:
	                foodDnn[85]=normalize(value,0.16666667f,1.0f);
	                break;
	            case 97:
	                foodDnn[86]=normalize(value,0.030355392f,0.58113545f);
	                break;
	            case 98:
	                foodDnn[87]=normalize(value,0.07692308f,1.0f);
	                break;
	            case 99:
	                foodDnn[88]=normalize(value,47.8f,815.52f);
	                break;
	            case 100:
	                foodDnn[89]=normalize(value,1.0f,22.0f);
	                break;
	            case 101:
	                foodDnn[90]=normalize(value,19.366f,59.345f);
	                break;
	            case 104:
	                foodDnn[91]=normalize(value,1.0f,5.0f);
	                break;
	            case 105:
	                foodDnn[92]=normalize(value,-45.0f,-2.0f);
	                break;
	            case 106:
	                foodDnn[93]=normalize(value,-19.9f,10.1f);
	                break;
	            case 107:
	                foodDnn[94]=normalize(value,1.0f,1.0f);
	                break;
	            case 108:
	                foodDnn[95]=normalize(value,0.9893617f,1.0f);
	                break;
	            case 109:
	                foodDnn[96]=normalize(value,1.0f,20.0f);
	                break;
	            case 110:
	                foodDnn[97]=normalize(value,2.0f,116.0f);
	                break;
	            case 111:
	                foodDnn[98]=normalize(value,1.0f,19.0f);
	                break;
	            case 112:
	                foodDnn[99]=normalize(value,2.0f,115.0f);
	                break;
	            case 113:
	                foodDnn[100]=normalize(value,30.0f,600.0f);
	                break;
	            case 114:
	                foodDnn[101]=normalize(value,25.0f,720.0f);
	                break;
	            case 115:
	                foodDnn[102]=normalize(value,36.0f,1560.0f);
	                break;
	            case 116:
	                foodDnn[103]=normalize(value,45.0f,2159.28f);
	                break;
	            case 117:
	                foodDnn[104]=normalize(value,57.6f,3567.0f);
	                break;
	            case 118:
	                foodDnn[105]=normalize(value,75.9f,5467.2f);
	                break;
	            case 119:
	                foodDnn[106]=normalize(value,100.0f,8024.0f);
	                break;
	            case 120:
	                foodDnn[107]=normalize(value,3.0f,208.0f);
	                break;
	            case 121:
	                foodDnn[108]=normalize(value,1.0f,9.0f);
	                break;
	            case 122:
	                foodDnn[109]=normalize(value,1.0f,15.0f);
	                break;
	            case 123:
	                foodDnn[110]=normalize(value,1.0f,75.0f);
	                break;
	            case 124:
	                foodDnn[111]=normalize(value,1.0f,6.0f);
	                break;
	            case 125:
	                foodDnn[112]=normalize(value,2.0f,131.0f);
	                break;
	            case 126:
	                foodDnn[113]=normalize(value,2.0f,207.0f);
	                break;
	            case 127:
	                foodDnn[114]=normalize(value,3.0f,319.0f);
	                break;
	            case 128:
	                foodDnn[115]=normalize(value,1.0f,12.0f);
	                break;
	            case 129:
	                foodDnn[116]=normalize(value,1.0f,20.0f);
	                break;
	            case 130:
	                foodDnn[117]=normalize(value,1.0f,33.0f);
	                break;
	            case 131:
	                foodDnn[118]=normalize(value,1.0f,19.0f);
	                break;
	            case 132:
	                foodDnn[119]=normalize(value,1.0f,30.0f);
	                break;
	            case 133:
	                foodDnn[120]=normalize(value,0.003197273f,0.064326525f);
	                break;
	            case 134:
	                foodDnn[121]=normalize(value,0.0028142352f,0.05154388f);
	                break;
	            case 135:
	                foodDnn[122]=normalize(value,5.2756248E-5f,0.009114978f);
	                break;
	            case 136:
	                foodDnn[123]=normalize(value,0.0010781606f,0.1474977f);
	                break;
	            case 137:
	                foodDnn[124]=normalize(value,0.003077439f,0.06219879f);
	                break;
	            case 138:
	                foodDnn[125]=normalize(value,5.484347E-5f,0.0106f);
	                break;
	            case 139:
	                foodDnn[126]=normalize(value,0.00132f,0.172f);
	                break;
	            case 140:
	                foodDnn[127]=normalize(value,16.18f,56.98421f);
	                break;
	            case 141:
	                foodDnn[128]=normalize(value,16.5f,58.347973f);
	                break;
	            case 200:
	                foodDnn[129]=normalize(value,0.6655f,0.8777f);
	                break;
	            case 201:
	                foodDnn[130]=normalize(value,4.0E-4f,0.0368f);
	                break;
	            case 202:
	                foodDnn[131]=normalize(value,0.1629f,0.5638f);
	                break;
	            case 203:
	                foodDnn[132]=normalize(value,4.0f,15.0f);
	                break;
	            case 204:
	                foodDnn[133]=normalize(value,15.37f,37.76f);
	                break;
	            case 205:
	                foodDnn[134]=normalize(value,81.9677f,121.0f);
	                break;
	            case 206:
	                foodDnn[135]=normalize(value,81.9677f,121.0f);
	                break;
	            case 207:
	                foodDnn[136]=normalize(value,0.6774f,118.3548f);
	                break;
	            case 220:
	                foodDnn[137]=normalize(value,0.064f,0.81f);
	                break;
	            case 221:
	                foodDnn[138]=normalize(value,4304.1f,109588.28f);
	                break;
	            case 222:
	                foodDnn[140]=normalize(value,110.0f,2463.0f);
	                break;
	            case 223:
	                foodDnn[141]=normalize(value,110.0f,2463.0f);
	                break;
	            case 226:
	                foodDnn[142]=normalize(value,110.0f,2463.0f);
	                break;
	            case 300:
	                foodDnn[143]=normalize(value,0.375f,0.979f);
	                break;
	            case 301:
	                foodDnn[144]=normalize(value,0.18f,0.68f);
	                break;
	            case 302:
	                foodDnn[145]=normalize(value,0.14f,2.45f);
	                break;
	            case 303:
	                foodDnn[146]=normalize(value,0.33f,4.0f);
	                break;
	            case 304:
	                foodDnn[147]=normalize(value,0.78f,9.35f);
	                break;
	            case 305:
	                foodDnn[148]=normalize(value,31.0f,40.0f);
	                break;
	            case 306:
	                foodDnn[149]=normalize(value,9.0f,31.0f);
	                break;
	            case 307:
	                foodDnn[150]=normalize(value,0.52f,0.82f);
	                break;
	            case 308:
	                foodDnn[151]=normalize(value,264.0f,538.0f);
	                break;
	            case 309:
	                foodDnn[152]=normalize(value,1.0f,1.0f);
	                break;
	            case 310:
	                foodDnn[153]=normalize(value,0.14f,2.08f);
	                break;
	            case 311:
	                foodDnn[154]=normalize(value,641.87f,3619.52f);
	                break;
	            case 312:
	                foodDnn[155]=normalize(value,4.41f,4.71f);
	                break;
	            case 313:
	                foodDnn[156]=normalize(value,0.02f,0.2f);
	                break;
	            case 314:
	                foodDnn[157]=normalize(value,65.0f,159.0f);
	                break;
	            case 315:
	                foodDnn[158]=normalize(value,3.0f,51.0f);
	                break;
	            case 316:
	                foodDnn[159]=normalize(value,97.28f,2007.77f);
	                break;
	            case 317:
	                foodDnn[160]=normalize(value,20.23f,58.47f);
	                break;
	            case 318:
	                foodDnn[161]=normalize(value,4.0f,65.5f);
	                break;
	            case 319:
	                foodDnn[162]=normalize(value,22.6f,692.46f);
	                break;
	            case 320:
	                foodDnn[163]=normalize(value,4.0f,96.0f);
	                break;
	            case 321:
	                foodDnn[164]=normalize(value,1.0f,25.0f);
	                break;
	            case 322:
	                foodDnn[165]=normalize(value,0.64f,1.97f);
	                break;
	            case 323:
	                foodDnn[166]=normalize(value,0.14f,0.6f);
	                break;
	            case 324:
	                foodDnn[167]=normalize(value,1.0f,53.0f);
	                break;
	            case 325:
	                foodDnn[168]=normalize(value,31.0f,42.0f);
	                break;
	            case 326:
	                foodDnn[169]=normalize(value,5.0f,40.0f);
	                break;
	            case 327:
	                foodDnn[170]=normalize(value,0.48f,0.83f);
	                break;
	            case 328:
	                foodDnn[171]=normalize(value,221.0f,640.0f);
	                break;
	            case 329:
	                foodDnn[172]=normalize(value,0.95f,1.0f);
	                break;
	            case 330:
	                foodDnn[173]=normalize(value,0.36f,2.31f);
	                break;
	            case 331:
	                foodDnn[174]=normalize(value,721.53f,4506.9f);
	                break;
	            case 332:
	                foodDnn[175]=normalize(value,4.28f,4.75f);
	                break;
	            case 333:
	                foodDnn[176]=normalize(value,55.0f,163.0f);
	                break;
	            case 334:
	                foodDnn[177]=normalize(value,0.422f,1.0f);
	                break;
	            case 335:
	                foodDnn[178]=normalize(value,8.99f,36.67f);
	                break;
	            case 336:
	                foodDnn[179]=normalize(value,-21.975056f,21.382412f);
	                break;
	            case 500:
	                foodDnn[180]=normalize(value,1.0f,9.0f);
	                break;
	            case 501:
	                foodDnn[181]=normalize(value,1.0f,16.0f);
	                break;
	            case 502:
	                foodDnn[182]=normalize(value,21.0f,294.0f);
	                break;
	            case 503:
	                foodDnn[183]=normalize(value,1.0f,13.0f);
	                break;
	            case 504:
	                foodDnn[184]=normalize(value,1.0f,8.0f);
	                break;
	            case 505:
	                foodDnn[185]=normalize(value,1.0f,9.0f);
	                break;
	            case 506:
	                foodDnn[186]=normalize(value,1.0f,6.0f);
	                break;
	            case 507:
	                foodDnn[187]=normalize(value,0.22f,1.0f);
	                break;
	            case 508:
	                foodDnn[188]=normalize(value,1.0f,5.0f);
	                break;
	            case 509:
	                foodDnn[189]=normalize(value,1.0f,3.0f);
	                break;
	            case 510:
	                foodDnn[190]=normalize(value,1.0f,4.0f);
	                break;
	            case 511:
	                foodDnn[191]=normalize(value,0.25f,1.0f);
	                break;
	            default:
	                break;
	        }
	        return foodDnn;

	    }

}
