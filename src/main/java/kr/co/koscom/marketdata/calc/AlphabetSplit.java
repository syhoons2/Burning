package kr.co.koscom.marketdata.calc;

public class AlphabetSplit {
	/*
	 * ********************************************** 자음 모음 분리 설연수 -> ㅅㅓㄹㅇㅕㄴㅅㅜ,
	 * 바보 -> ㅂㅏㅂㅗ
	 **********************************************/
	/** 초성 - 가(ㄱ), 날(ㄴ) 닭(ㄷ) */
	public static char[] arrChoSung = { 0x3131, 0x3132, 0x3134, 0x3137, 0x3138, 0x3139, 0x3141, 0x3142, 0x3143, 0x3145,
			0x3146, 0x3147, 0x3148, 0x3149, 0x314a, 0x314b, 0x314c, 0x314d, 0x314e };
	/** 중성 - 가(ㅏ), 야(ㅑ), 뺨(ㅑ) */
	public static char[] arrJungSung = { 0x314f, 0x3150, 0x3151, 0x3152, 0x3153, 0x3154, 0x3155, 0x3156, 0x3157, 0x3158,
			0x3159, 0x315a, 0x315b, 0x315c, 0x315d, 0x315e, 0x315f, 0x3160, 0x3161, 0x3162, 0x3163 };
	/** 종성 - 가(없음), 갈(ㄹ) 천(ㄴ) */
	public static char[] arrJongSung = { 0x0000, 0x3131, 0x3132, 0x3133, 0x3134, 0x3135, 0x3136, 0x3137, 0x3139, 0x313a,
			0x313b, 0x313c, 0x313d, 0x313e, 0x313f, 0x3140, 0x3141, 0x3142, 0x3144, 0x3145, 0x3146, 0x3147, 0x3148,
			0x314a, 0x314b, 0x314c, 0x314d, 0x314e };

	/*
	 * ********************************************** 알파벳으로 변환 설연수 -> tjfdustn,
	 * 멍충 -> ajdcnd
	 **********************************************/
	/** 초성 - 가(ㄱ), 날(ㄴ) 닭(ㄷ) */
	public static String[] arrChoSungEng = { "r", "R", "s", "e", "E", "f", "a", "q", "Q", "t", "T", "d", "w", "W", "c",
			"z", "x", "v", "g" };

	/** 중성 - 가(ㅏ), 야(ㅑ), 뺨(ㅑ) */
	public static String[] arrJungSungEng = { "k", "o", "i", "O", "j", "p", "u", "P", "h", "hk", "ho", "hl", "y", "n",
			"nj", "np", "nl", "b", "m", "ml", "l" };

	/** 종성 - 가(없음), 갈(ㄹ) 천(ㄴ) */
	public static String[] arrJongSungEng = { "", "r", "R", "rt", "s", "sw", "sg", "e", "f", "fr", "fa", "fq", "ft",
			"fx", "fv", "fg", "a", "q", "qt", "t", "T", "d", "w", "c", "z", "x", "v", "g" };

	/** 단일 자음 - ㄱ,ㄴ,ㄷ,ㄹ... (ㄸ,ㅃ,ㅉ은 단일자음(초성)으로 쓰이지만 단일자음으론 안쓰임) */
	public static String[] arrSingleJaumEng = { "r", "R", "rt", "s", "sw", "sg", "e", "E", "f", "fr", "fa", "fq", "ft",
			"fx", "fv", "fg", "a", "q", "Q", "qt", "t", "T", "d", "w", "W", "c", "z", "x", "v", "g" };

	public int calcHangulValue(String str) {

		String hangul = "ㄱㄴㅇㄷㅅㅈㅋㄲㄹㅁㅊㅌㅎㅂㅍㄸㅆㅃㅡㅣㅏㅓㅗㅜㅢㅑㅕㅛㅠㅐㅔㅚㅟㅒㅖㅝㅞㅙ";
		int[] hangul_cnt = { 1, 1, 1, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 4, 4, 4, 4, 8, 1, 1, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3,
				3, 3, 3, 4, 4, 4, 5, 5 };

		return hangul_cnt[hangul.indexOf(str)];

	}

	public int[] nameSplit(String word) {

		// String word = "설연수 멍충아ㅏㅠkk!@#$%^&*()★"; // 분리할 단어
		String result = ""; // 결과 저장할 변수
		String resultEng = ""; // 알파벳으로

		int[] namevaluelist = new int[3];

		for (int i = 0; i < word.length(); i++) {
			int chosung_value = 0;
			int jungsung_value = 0;
			int jongsung_value = 0;
			/* 한글자씩 읽어들인다. */
			char chars = (char) (word.charAt(i) - 0xAC00);

			if (chars >= 0 && chars <= 11172) {
				/* A. 자음과 모음이 합쳐진 글자인경우 */

				/* A-1. 초/중/종성 분리 */
				int chosung = chars / (21 * 28);
				int jungsung = chars % (21 * 28) / 28;
				int jongsung = chars % (21 * 28) % 28;

				/* A-2. result에 담기 */
				result = result + arrChoSung[chosung] + arrJungSung[jungsung];
				chosung_value = calcHangulValue(arrChoSung[chosung] + "");// System.out.println("초성획수
																			// :
																			// "
																			// +
																			// calcHangulValue(arrChoSung[chosung]
																			// +
																			// ""));
				jungsung_value = calcHangulValue(arrJungSung[jungsung] + "");// System.out.println("중성획수
																				// :
																				// "
																				// +
																				// calcHangulValue(arrJungSung[jungsung]
																				// +
																				// ""));

				/* 자음분리 */
				if (jongsung != 0x0000) {
					/* A-3. 종성이 존재할경우 result에 담는다 */
					jongsung_value = calcHangulValue(arrJongSung[jongsung] + ""); // System.out.println("종성획수
																					// :
																					// "
																					// +
																					// calcHangulValue(arrJongSung[jongsung]
																					// +
																					// ""));

					result = result + arrJongSung[jongsung];
				}

				/* 알파벳으로 */
				resultEng = resultEng + arrChoSungEng[chosung] + arrJungSungEng[jungsung];
				if (jongsung != 0x0000) {
					/* A-3. 종성이 존재할경우 result에 담는다 */
					resultEng = resultEng + arrJongSungEng[jongsung];
				}

			} else {
				/* B. 한글이 아니거나 자음만 있을경우 */

				/* 자음분리 */
				result = result + ((char) (chars + 0xAC00));

				/* 알파벳으로 */
				if (chars >= 34097 && chars <= 34126) {
					/* 단일자음인 경우 */
					int jaum = (chars - 34097);
					resultEng = resultEng + arrSingleJaumEng[jaum];
				} else if (chars >= 34127 && chars <= 34147) {
					/* 단일모음인 경우 */
					int moum = (chars - 34127);
					resultEng = resultEng + arrJungSungEng[moum];
				} else {
					/* 알파벳인 경우 */
					resultEng = resultEng + ((char) (chars + 0xAC00));
				}
			} // if

			// 추가하기
			namevaluelist[i] = chosung_value + jungsung_value + jongsung_value;
			System.out.println("### namevaluelist: " + namevaluelist[i]);

		} // for

		System.out.println("============ result ==========");
		System.out.println("단어     : " + word);
		System.out.println("자음분리 : " + result);
		System.out.println("알파벳   : " + resultEng);
		System.out.println(word.length());

		return namevaluelist;
	}
}
