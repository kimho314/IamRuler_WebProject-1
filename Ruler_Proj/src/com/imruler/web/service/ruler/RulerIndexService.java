package com.imruler.web.service.ruler;

import com.imruler.web.appstorage.entity.man.ManInverseTriangle;
import com.imruler.web.appstorage.entity.man.ManNomal;
import com.imruler.web.appstorage.entity.man.ManSmallInverseTriangle;
import com.imruler.web.appstorage.entity.man.ManSquare;
import com.imruler.web.appstorage.entity.man.ManTriangle;
import com.imruler.web.appstorage.entity.woman.WomanInverseTriangle;
import com.imruler.web.appstorage.entity.woman.WomanNomal;
import com.imruler.web.appstorage.entity.woman.WomanSmallInverseTriangle;
import com.imruler.web.appstorage.entity.woman.WomanSquare;
import com.imruler.web.appstorage.entity.woman.WomanTriangle;
import com.imruler.web.dao.IndexDao;
import com.imruler.web.dao.MemberDao;
import com.imruler.web.dao.jdbc.JdbcMemberDao;
import com.imruler.web.entity.Member;

public class RulerIndexService implements IndexDao {
	private MemberDao memberDao;
	// 1. 사이즈가 큼 // 2. 알맞은 사이즈 // 3. 사이즈 작음

	public RulerIndexService() {
		memberDao = new JdbcMemberDao();
	}

	@Override
	public Member get(int id, int height, int weidth, String gender, int age, String bodyshape) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int top(int x, int y, String gender, String bodyshape, int shoulderWidth, int chestBreadth, int sleeveLength, int topTotalLength) {
		System.out.println("상의 비교");
		System.out.println(gender);
		if (gender.equals("man")) {
			System.out.println("남자");
			if (bodyshape.equals("nomal")) {
				System.out.println("보통");
				ManNomal nomal = new ManNomal();
				int[] size = nomal.ManNomal(x, y);
				if (size[0] < shoulderWidth && size[1] < chestBreadth && size[2] < sleeveLength && size[7] < topTotalLength) {
					//System.out.println("사이즈가 큼");
					return 1;
				} else if (size[0] <= shoulderWidth && size[1] <= chestBreadth && size[2] <= sleeveLength && size[7] <= topTotalLength) {
					//System.out.println("알맞은 사이즈");
					return 2;
				} else if (size[0] > shoulderWidth || size[1] > chestBreadth || size[2] > sleeveLength || size[7] > topTotalLength) {
					//System.out.println("사이즈가 작음");
					return 3;
				}
			} else if (bodyshape.equals("smallInverseTriangle")) {
				ManSmallInverseTriangle msit = new ManSmallInverseTriangle();
				int[] size = msit.ManSmallInverseTriangle(x, y);
				if (size[0] < shoulderWidth && size[1] < chestBreadth && size[2] < sleeveLength && size[7] < topTotalLength) {
					//System.out.println("사이즈가 큼");
					return 1;
				} else if (size[0] <= shoulderWidth && size[1] <= chestBreadth && size[2] <= sleeveLength && size[7] <= topTotalLength) {
					//System.out.println("알맞은 사이즈");
					return 2;
				} else if (size[0] > shoulderWidth || size[1] > chestBreadth || size[2] > sleeveLength || size[7] > topTotalLength) {
					//System.out.println("사이즈가 작음");
					return 3;
				}
			} else if (bodyshape.equals("inverseTriangle")) {
				ManInverseTriangle mit = new ManInverseTriangle();
				int[] size = mit.ManInverseTriangle(x, y);
				if (size[0] < shoulderWidth && size[1] < chestBreadth && size[2] < sleeveLength && size[7] < topTotalLength) {
					//System.out.println("사이즈가 큼");
					return 1;
				} else if (size[0] <= shoulderWidth && size[1] <= chestBreadth && size[2] <= sleeveLength && size[7] <= topTotalLength) {
					//System.out.println("알맞은 사이즈");
					return 2;
				} else if (size[0] > shoulderWidth || size[1] > chestBreadth || size[2] > sleeveLength || size[7] > topTotalLength) {
					//System.out.println("사이즈가 작음");
					return 3;
				}
			} else if (bodyshape.equals("square")) {
				ManSquare square = new ManSquare();
				int[] size = square.ManSquare(x, y);
				if (size[0] < shoulderWidth && size[1] < chestBreadth && size[2] < sleeveLength && size[7] < topTotalLength) {
					//System.out.println("사이즈가 큼");
					return 1;
				} else if (size[0] <= shoulderWidth && size[1] <= chestBreadth && size[2] <= sleeveLength && size[7] <= topTotalLength) {
					//System.out.println("알맞은 사이즈");
					return 2;
				} else if (size[0] > shoulderWidth || size[1] > chestBreadth || size[2] > sleeveLength || size[7] > topTotalLength) {
					//System.out.println("사이즈가 작음");
					return 3;
				}
			} else if (bodyshape.equals("triangle")) {
				ManTriangle triangle = new ManTriangle();
				int[] size = triangle.ManTriangle(x, y);
				if (size[0] < shoulderWidth && size[1] < chestBreadth && size[2] < sleeveLength && size[7] < topTotalLength) {
					//System.out.println("사이즈가 큼");
					return 1;
				} else if (size[0] <= shoulderWidth && size[1] <= chestBreadth && size[2] <= sleeveLength && size[7] <= topTotalLength) {
					//System.out.println("알맞은 사이즈");
					return 2;
				} else if (size[0] > shoulderWidth || size[1] > chestBreadth || size[2] > sleeveLength || size[7] > topTotalLength) {
					//System.out.println("사이즈가 작음");
					return 3;
				}
			}
		}else if(gender.equals("woman")) {
			if (bodyshape.equals("nomal")) {
				WomanNomal nomal = new WomanNomal();
				int[] size = nomal.WomanNomal(x, y);
				if (size[0] < shoulderWidth && size[1] < chestBreadth && size[2] < sleeveLength && size[7] < topTotalLength) {
					//System.out.println("사이즈가 큼");
					return 1;
				} else if (size[0] <= shoulderWidth && size[1] <= chestBreadth && size[2] <= sleeveLength && size[7] <= topTotalLength) {
					//System.out.println("알맞은 사이즈");
					return 2;
				} else if (size[0] > shoulderWidth || size[1] > chestBreadth || size[2] > sleeveLength || size[7] > topTotalLength) {
					//System.out.println("사이즈가 작음");
					return 3;
				}
			} else if (bodyshape.equals("smallInverseTriangle")) {
				WomanSmallInverseTriangle msit = new WomanSmallInverseTriangle();
				int[] size = msit.WomanSmallInverseTriangle(x, y);
				if (size[0] < shoulderWidth && size[1] < chestBreadth && size[2] < sleeveLength && size[7] < topTotalLength) {
					//System.out.println("사이즈가 큼");
					return 1;
				} else if (size[0] <= shoulderWidth && size[1] <= chestBreadth && size[2] <= sleeveLength && size[7] <= topTotalLength) {
					//System.out.println("알맞은 사이즈");
					return 2;
				} else if (size[0] > shoulderWidth || size[1] > chestBreadth || size[2] > sleeveLength || size[7] > topTotalLength) {
					//System.out.println("사이즈가 작음");
					return 3;
				}
			} else if (bodyshape.equals("inverseTriangle")) {
				WomanInverseTriangle mit = new WomanInverseTriangle();
				int[] size = mit.WomanInverseTriangle(x, y);
				if (size[0] < shoulderWidth && size[1] < chestBreadth && size[2] < sleeveLength && size[7] < topTotalLength) {
					//System.out.println("사이즈가 큼");
					return 1;
				} else if (size[0] <= shoulderWidth && size[1] <= chestBreadth && size[2] <= sleeveLength && size[7] <= topTotalLength) {
					//System.out.println("알맞은 사이즈");
					return 2;
				} else if (size[0] > shoulderWidth || size[1] > chestBreadth || size[2] > sleeveLength || size[7] > topTotalLength) {
					//System.out.println("사이즈가 작음");
					return 3;
				}
			} else if (bodyshape.equals("square")) {
				WomanSquare square = new WomanSquare();
				int[] size = square.WomanSquare(x, y);
				if (size[0] < shoulderWidth && size[1] < chestBreadth && size[2] < sleeveLength && size[7] < topTotalLength) {
					//System.out.println("사이즈가 큼");
					return 1;
				} else if (size[0] <= shoulderWidth && size[1] <= chestBreadth && size[2] <= sleeveLength && size[7] <= topTotalLength) {
					//System.out.println("알맞은 사이즈");
					return 2;
				} else if (size[0] > shoulderWidth || size[1] > chestBreadth || size[2] > sleeveLength || size[7] > topTotalLength) {
					//System.out.println("사이즈가 작음");
					return 3;
				}
			} else if (bodyshape.equals("triangle")) {
				WomanTriangle triangle = new WomanTriangle();
				int[] size = triangle.WomanTriangle(x, y);
				if (size[0] < shoulderWidth && size[1] < chestBreadth && size[2] < sleeveLength && size[7] < topTotalLength) {
					//System.out.println("사이즈가 큼");
					return 1;
				} else if (size[0] <= shoulderWidth && size[1] <= chestBreadth && size[2] <= sleeveLength && size[7] <= topTotalLength) {
					//System.out.println("알맞은 사이즈");
					return 2;
				} else if (size[0] > shoulderWidth || size[1] > chestBreadth || size[2] > sleeveLength || size[7] > topTotalLength) {
					//System.out.println("사이즈가 작음");
					return 3;
				}
			}
		}
		return 0;
	}

	@Override
	public int outer(int x, int y, String gender, String bodyshape, int shoulderWidth, int chestBreadth, int sleeveLength, int topTotalLength) {
		System.out.println("아우터 비교");
		if (gender.equals("man")) {
			if (bodyshape.equals("nomal")) {
				ManNomal nomal = new ManNomal();
				int[] size = nomal.ManNomal(x, y);
				if (size[0]+2 < shoulderWidth && size[1]+5 < chestBreadth && size[2] < sleeveLength && size[7] < topTotalLength) {
					//System.out.println("사이즈가 큼");
					return 1;
				} else if (size[0]+2 <= shoulderWidth && size[1]+5 <= chestBreadth && size[2] <= sleeveLength && size[7] <= topTotalLength) {
					//System.out.println("알맞은 사이즈");
					return 2;
				} else if (size[0]+2 > shoulderWidth || size[1]+5 > chestBreadth || size[2] > sleeveLength || size[7] > topTotalLength) {
					//System.out.println("사이즈가 작음");
					return 3;
				}
			} else if (bodyshape.equals("smallInverseTriangle")) {
				ManSmallInverseTriangle msit = new ManSmallInverseTriangle();
				int[] size = msit.ManSmallInverseTriangle(x, y);
				if (size[0]+2 < shoulderWidth && size[1]+5 < chestBreadth && size[2] < sleeveLength && size[7] < topTotalLength) {
					//System.out.println("사이즈가 큼");
					return 1;
				} else if (size[0]+2 <= shoulderWidth && size[1]+5 <= chestBreadth && size[2] <= sleeveLength && size[7] <= topTotalLength) {
					//System.out.println("알맞은 사이즈");
					return 2;
				} else if (size[0]+2 > shoulderWidth || size[1]+5 > chestBreadth || size[2] > sleeveLength || size[7] > topTotalLength) {
					//System.out.println("사이즈가 작음");
					return 3;
				}
			} else if (bodyshape.equals("inverseTriangle")) {
				ManInverseTriangle mit = new ManInverseTriangle();
				int[] size = mit.ManInverseTriangle(x, y);
				if (size[0]+2 < shoulderWidth && size[1]+5 < chestBreadth && size[2] < sleeveLength && size[7] < topTotalLength) {
					//System.out.println("사이즈가 큼");
					return 1;
				} else if (size[0]+2 <= shoulderWidth && size[1]+5 <= chestBreadth && size[2] <= sleeveLength && size[7] <= topTotalLength) {
					//System.out.println("알맞은 사이즈");
					return 2;
				} else if (size[0]+2 > shoulderWidth || size[1]+5 > chestBreadth || size[2] > sleeveLength || size[7] > topTotalLength) {
					//System.out.println("사이즈가 작음");
					return 3;
				}
			} else if (bodyshape.equals("square")) {
				ManSquare square = new ManSquare();
				int[] size = square.ManSquare(x, y);
				if (size[0]+2 < shoulderWidth && size[1]+5 < chestBreadth && size[2] < sleeveLength && size[7] < topTotalLength) {
					//System.out.println("사이즈가 큼");
					return 1;
				} else if (size[0]+2 <= shoulderWidth && size[1]+5 <= chestBreadth && size[2] <= sleeveLength && size[7] <= topTotalLength) {
					//System.out.println("알맞은 사이즈");
					return 2;
				} else if (size[0]+2 > shoulderWidth || size[1]+5 > chestBreadth || size[2] > sleeveLength || size[7] > topTotalLength) {
					//System.out.println("사이즈가 작음");
					return 3;
				}
			} else if (bodyshape.equals("triangle")) {
				ManTriangle triangle = new ManTriangle();
				int[] size = triangle.ManTriangle(x, y);
				if (size[0]+2 < shoulderWidth && size[1]+5 < chestBreadth && size[2] < sleeveLength && size[7] < topTotalLength) {
					//System.out.println("사이즈가 큼");
					return 1;
				} else if (size[0]+2 <= shoulderWidth && size[1]+5 <= chestBreadth && size[2] <= sleeveLength && size[7] <= topTotalLength) {
					//System.out.println("알맞은 사이즈");
					return 2;
				} else if (size[0]+2 > shoulderWidth || size[1]+5 > chestBreadth || size[2] > sleeveLength || size[7] > topTotalLength) {
					//System.out.println("사이즈가 작음");
					return 3;
				}
			}
		}else if(gender.equals("woman")) {
			if (bodyshape.equals("nomal")) {
				WomanNomal nomal = new WomanNomal();
				int[] size = nomal.WomanNomal(x, y);
				if (size[0]+2 < shoulderWidth && size[1]+5 < chestBreadth && size[2] < sleeveLength && size[7] < topTotalLength) {
					//System.out.println("사이즈가 큼");
					return 1;
				} else if (size[0]+2 <= shoulderWidth && size[1]+5 <= chestBreadth && size[2] <= sleeveLength && size[7] <= topTotalLength) {
					//System.out.println("알맞은 사이즈");
					return 2;
				} else if (size[0]+2 > shoulderWidth || size[1]+5 > chestBreadth || size[2] > sleeveLength || size[7] > topTotalLength) {
					//System.out.println("사이즈가 작음");
					return 3;
				}
			} else if (bodyshape.equals("smallInverseTriangle")) {
				WomanSmallInverseTriangle msit = new WomanSmallInverseTriangle();
				int[] size = msit.WomanSmallInverseTriangle(x, y);
				if (size[0]+2 < shoulderWidth && size[1]+5 < chestBreadth && size[2] < sleeveLength && size[7] < topTotalLength) {
					//System.out.println("사이즈가 큼");
					return 1;
				} else if (size[0]+2 <= shoulderWidth && size[1]+5 <= chestBreadth && size[2] <= sleeveLength && size[7] <= topTotalLength) {
					//System.out.println("알맞은 사이즈");
					return 2;
				} else if (size[0]+2 > shoulderWidth || size[1]+5 > chestBreadth || size[2] > sleeveLength || size[7] > topTotalLength) {
					//System.out.println("사이즈가 작음");
					return 3;
				}
			} else if (bodyshape.equals("inverseTriangle")) {
				WomanInverseTriangle mit = new WomanInverseTriangle();
				int[] size = mit.WomanInverseTriangle(x, y);
				if (size[0]+2 < shoulderWidth && size[1]+5 < chestBreadth && size[2] < sleeveLength && size[7] < topTotalLength) {
					//System.out.println("사이즈가 큼");
					return 1;
				} else if (size[0]+2 <= shoulderWidth && size[1]+5 <= chestBreadth && size[2] <= sleeveLength && size[7] <= topTotalLength) {
					//System.out.println("알맞은 사이즈");
					return 2;
				} else if (size[0]+2 > shoulderWidth || size[1]+5 > chestBreadth || size[2] > sleeveLength || size[7] > topTotalLength) {
					//System.out.println("사이즈가 작음");
					return 3;
				}
			} else if (bodyshape.equals("square")) {
				WomanSquare square = new WomanSquare();
				int[] size = square.WomanSquare(x, y);
				if (size[0]+2 < shoulderWidth && size[1]+5 < chestBreadth && size[2] < sleeveLength && size[7] < topTotalLength) {
					//System.out.println("사이즈가 큼");
					return 1;
				} else if (size[0]+2 <= shoulderWidth && size[1]+5 <= chestBreadth && size[2] <= sleeveLength && size[7] <= topTotalLength) {
					//System.out.println("알맞은 사이즈");
					return 2;
				} else if (size[0]+2 > shoulderWidth || size[1]+5 > chestBreadth || size[2] > sleeveLength || size[7] > topTotalLength) {
					//System.out.println("사이즈가 작음");
					return 3;
				}
			} else if (bodyshape.equals("triangle")) {
				WomanTriangle triangle = new WomanTriangle();
				int[] size = triangle.WomanTriangle(x, y);
				if (size[0]+2 < shoulderWidth && size[1]+5 < chestBreadth && size[2] < sleeveLength && size[7] < topTotalLength) {
					//System.out.println("사이즈가 큼");
					return 1;
				} else if (size[0]+2 <= shoulderWidth && size[1]+5 <= chestBreadth && size[2] <= sleeveLength && size[7] <= topTotalLength) {
					//System.out.println("알맞은 사이즈");
					return 2;
				} else if (size[0]+2 > shoulderWidth || size[1]+5 > chestBreadth || size[2] > sleeveLength || size[7] > topTotalLength) {
					//System.out.println("사이즈가 작음");
					return 3;
				}
			}
		}
		return 0;
	}

	@Override
	public int pants(int x, int y, String gender, String bodyshape, int waistWidth, int thighWidth, int crotchWidth, int hemWidth, int pantsTotalLength) {
		System.out.println("바지 비교");
		if (gender.equals("man")) {
			if (bodyshape.equals("nomal")) {
				ManNomal nomal = new ManNomal();
				int[] size = nomal.ManNomal(x, y);
				if (size[2] < waistWidth && size[4] < crotchWidth && size[5] < thighWidth && size[6] < hemWidth && size[8]< pantsTotalLength) {
					//System.out.println("사이즈가 큼");
					return 1;
				} else if (size[2] <= waistWidth && size[4] <= crotchWidth && size[5] <= thighWidth && size[6] <= hemWidth && size[8] <= pantsTotalLength) {
					//System.out.println("알맞은 사이즈");
					return 2;
				} else if (size[2] > waistWidth || size[4] > crotchWidth || size[5] > thighWidth || size[6] > hemWidth || size[8] > pantsTotalLength) {
					//System.out.println("사이즈가 작음");
					return 3;
				}
			} else if (bodyshape.equals("smallInverseTriangle")) {
				ManSmallInverseTriangle msit = new ManSmallInverseTriangle();
				int[] size = msit.ManSmallInverseTriangle(x, y);
				if (size[2] < waistWidth && size[4] < crotchWidth && size[5] < thighWidth && size[6] < hemWidth && size[8]< pantsTotalLength) {
					//System.out.println("사이즈가 큼");
					return 1;
				} else if (size[2] <= waistWidth && size[4] <= crotchWidth && size[5] <= thighWidth && size[6] <= hemWidth && size[8] <= pantsTotalLength) {
					//System.out.println("알맞은 사이즈");
					return 2;
				} else if (size[2] > waistWidth || size[4] > crotchWidth || size[5] > thighWidth || size[6] > hemWidth || size[8] > pantsTotalLength) {
					//System.out.println("사이즈가 작음");
					return 3;
				}
			} else if (bodyshape.equals("inverseTriangle")) {
				ManInverseTriangle mit = new ManInverseTriangle();
				int[] size = mit.ManInverseTriangle(x, y);
				if (size[2] < waistWidth && size[4] < crotchWidth && size[5] < thighWidth && size[6] < hemWidth && size[8]< pantsTotalLength) {
					//System.out.println("사이즈가 큼");
					return 1;
				} else if (size[2] <= waistWidth && size[4] <= crotchWidth && size[5] <= thighWidth && size[6] <= hemWidth && size[8] <= pantsTotalLength) {
					//System.out.println("알맞은 사이즈");
					return 2;
				} else if (size[2] > waistWidth || size[4] > crotchWidth || size[5] > thighWidth || size[6] > hemWidth || size[8] > pantsTotalLength) {
					//System.out.println("사이즈가 작음");
					return 3;
				}
			} else if (bodyshape.equals("square")) {
				ManSquare square = new ManSquare();
				int[] size = square.ManSquare(x, y);
				if (size[2] < waistWidth && size[4] < crotchWidth && size[5] < thighWidth && size[6] < hemWidth && size[8]< pantsTotalLength) {
					//System.out.println("사이즈가 큼");
					return 1;
				} else if (size[2] <= waistWidth && size[4] <= crotchWidth && size[5] <= thighWidth && size[6] <= hemWidth && size[8] <= pantsTotalLength) {
					//System.out.println("알맞은 사이즈");
					return 2;
				} else if (size[2] > waistWidth || size[4] > crotchWidth || size[5] > thighWidth || size[6] > hemWidth || size[8] > pantsTotalLength) {
					//System.out.println("사이즈가 작음");
					return 3;
				}
			} else if (bodyshape.equals("triangle")) {
				ManTriangle triangle = new ManTriangle();
				int[] size = triangle.ManTriangle(x, y);
				if (size[2] < waistWidth && size[4] < crotchWidth && size[5] < thighWidth && size[6] < hemWidth && size[8]< pantsTotalLength) {
					//System.out.println("사이즈가 큼");
					return 1;
				} else if (size[2] <= waistWidth && size[4] <= crotchWidth && size[5] <= thighWidth && size[6] <= hemWidth && size[8] <= pantsTotalLength) {
					//System.out.println("알맞은 사이즈");
					return 2;
				} else if (size[2] > waistWidth || size[4] > crotchWidth || size[5] > thighWidth || size[6] > hemWidth || size[8] > pantsTotalLength) {
					//System.out.println("사이즈가 작음");
					return 3;
				}
			}
		} else if (gender.equals("woman")) {
			if (bodyshape.equals("nomal")) {
				WomanNomal nomal = new WomanNomal();
				int[] size = nomal.WomanNomal(x, y);
				if (size[2] < waistWidth && size[4] < crotchWidth && size[5] < thighWidth && size[6] < hemWidth && size[8]< pantsTotalLength) {
					//System.out.println("사이즈가 큼");
					return 1;
				} else if (size[2] <= waistWidth && size[4] <= crotchWidth && size[5] <= thighWidth && size[6] <= hemWidth && size[8] <= pantsTotalLength) {
					//System.out.println("알맞은 사이즈");
					return 2;
				} else if (size[2] > waistWidth || size[4] > crotchWidth || size[5] > thighWidth || size[6] > hemWidth || size[8] > pantsTotalLength) {
					//System.out.println("사이즈가 작음");
					return 3;
				}
			} else if (bodyshape.equals("smallInverseTriangle")) {
				WomanSmallInverseTriangle msit = new WomanSmallInverseTriangle();
				int[] size = msit.WomanSmallInverseTriangle(x, y);
				if (size[2] < waistWidth && size[4] < crotchWidth && size[5] < thighWidth && size[6] < hemWidth && size[8]< pantsTotalLength) {
					//System.out.println("사이즈가 큼");
					return 1;
				} else if (size[2] <= waistWidth && size[4] <= crotchWidth && size[5] <= thighWidth && size[6] <= hemWidth && size[8] <= pantsTotalLength) {
					//System.out.println("알맞은 사이즈");
					return 2;
				} else if (size[2] > waistWidth || size[4] > crotchWidth || size[5] > thighWidth || size[6] > hemWidth || size[8] > pantsTotalLength) {
					//System.out.println("사이즈가 작음");
					return 3;
				}
			} else if (bodyshape.equals("inverseTriangle")) {
				WomanInverseTriangle mit = new WomanInverseTriangle();
				int[] size = mit.WomanInverseTriangle(x, y);
				if (size[2] < waistWidth && size[4] < crotchWidth && size[5] < thighWidth && size[6] < hemWidth && size[8]< pantsTotalLength) {
					//System.out.println("사이즈가 큼");
					return 1;
				} else if (size[2] <= waistWidth && size[4] <= crotchWidth && size[5] <= thighWidth && size[6] <= hemWidth && size[8] <= pantsTotalLength) {
					//System.out.println("알맞은 사이즈");
					return 2;
				} else if (size[2] > waistWidth || size[4] > crotchWidth || size[5] > thighWidth || size[6] > hemWidth || size[8] > pantsTotalLength) {
					//System.out.println("사이즈가 작음");
					return 3;
				}
			} else if (bodyshape.equals("square")) {
				WomanSquare square = new WomanSquare();
				int[] size = square.WomanSquare(x, y);
				if (size[2] < waistWidth && size[4] < crotchWidth && size[5] < thighWidth && size[6] < hemWidth && size[8]< pantsTotalLength) {
					//System.out.println("사이즈가 큼");
					return 1;
				} else if (size[2] <= waistWidth && size[4] <= crotchWidth && size[5] <= thighWidth && size[6] <= hemWidth && size[8] <= pantsTotalLength) {
					//System.out.println("알맞은 사이즈");
					return 2;
				} else if (size[2] > waistWidth || size[4] > crotchWidth || size[5] > thighWidth || size[6] > hemWidth || size[8] > pantsTotalLength) {
					//System.out.println("사이즈가 작음");
					return 3;
				}
			} else if (bodyshape.equals("triangle")) {
				WomanTriangle triangle = new WomanTriangle();
				int[] size = triangle.WomanTriangle(x, y);
				if (size[2] < waistWidth && size[4] < crotchWidth && size[5] < thighWidth && size[6] < hemWidth && size[8]< pantsTotalLength) {
					//System.out.println("사이즈가 큼");
					return 1;
				} else if (size[2] <= waistWidth && size[4] <= crotchWidth && size[5] <= thighWidth && size[6] <= hemWidth && size[8] <= pantsTotalLength) {
					//System.out.println("알맞은 사이즈");
					return 2;
				} else if (size[2] > waistWidth || size[4] > crotchWidth || size[5] > thighWidth || size[6] > hemWidth || size[8] > pantsTotalLength) {
					//System.out.println("사이즈가 작음");
					return 3;
				}
			}
		}
		return 0;
	}

	@Override
	public int skirt(int x, int y, String gender, String bodyshape, int waistWidth, int skirtHemWidth, int skirtTotalLength) {
		System.out.println("치마 비교");
		if(gender.equals("woman")) {
			if (bodyshape.equals("nomal")) {
				WomanNomal nomal = new WomanNomal();
				int[] size = nomal.WomanNomal(x, y);
				if (size[2] < waistWidth && size[6] < skirtHemWidth && size[11] < skirtTotalLength) {
					//System.out.println("사이즈가 큼");
					return 1;
				} else if (size[2] <= waistWidth && size[6] <= skirtHemWidth && size[11] <= skirtTotalLength) {
					//System.out.println("알맞은 사이즈");
					return 2;
				} else if (size[2] > waistWidth || size[6] > skirtHemWidth || size[11] > skirtTotalLength) {
					//System.out.println("사이즈가 작음");
					return 3;
				}
			} else if (bodyshape.equals("smallInverseTriangle")) {
				WomanSmallInverseTriangle msit = new WomanSmallInverseTriangle();
				int[] size = msit.WomanSmallInverseTriangle(x, y);
				if (size[2] < waistWidth && size[6] < skirtHemWidth && size[11] < skirtTotalLength) {
					//System.out.println("사이즈가 큼");
					return 1;
				} else if (size[2] <= waistWidth && size[6] <= skirtHemWidth && size[11] <= skirtTotalLength) {
					//System.out.println("알맞은 사이즈");
					return 2;
				} else if (size[2] > waistWidth || size[6] > skirtHemWidth || size[11] > skirtTotalLength) {
					//System.out.println("사이즈가 작음");
					return 3;
				}
			} else if (bodyshape.equals("inverseTriangle")) {
				WomanInverseTriangle mit = new WomanInverseTriangle();
				int[] size = mit.WomanInverseTriangle(x, y);
				if (size[2] < waistWidth && size[6] < skirtHemWidth && size[11] < skirtTotalLength) {
					//System.out.println("사이즈가 큼");
					return 1;
				} else if (size[2] <= waistWidth && size[6] <= skirtHemWidth && size[11] <= skirtTotalLength) {
					//System.out.println("알맞은 사이즈");
					return 2;
				} else if (size[2] > waistWidth || size[6] > skirtHemWidth || size[11] > skirtTotalLength) {
					//System.out.println("사이즈가 작음");
					return 3;
				}
			} else if (bodyshape.equals("square")) {
				WomanSquare square = new WomanSquare();
				int[] size = square.WomanSquare(x, y);
				if (size[2] < waistWidth && size[6] < skirtHemWidth && size[11] < skirtTotalLength) {
					//System.out.println("사이즈가 큼");
					return 1;
				} else if (size[2] <= waistWidth && size[6] <= skirtHemWidth && size[11] <= skirtTotalLength) {
					//System.out.println("알맞은 사이즈");
					return 2;
				} else if (size[2] > waistWidth || size[6] > skirtHemWidth || size[11] > skirtTotalLength) {
					//System.out.println("사이즈가 작음");
					return 3;
				}
			} else if (bodyshape.equals("triangle")) {
				WomanTriangle triangle = new WomanTriangle();
				int[] size = triangle.WomanTriangle(x, y);
				if (size[2] < waistWidth && size[6] < skirtHemWidth && size[11] < skirtTotalLength) {
					//System.out.println("사이즈가 큼");
					return 1;
				} else if (size[2] <= waistWidth && size[6] <= skirtHemWidth && size[11] <= skirtTotalLength) {
					//System.out.println("알맞은 사이즈");
					return 2;
				} else if (size[2] > waistWidth || size[6] > skirtHemWidth || size[11] > skirtTotalLength) {
					//System.out.println("사이즈가 작음");
					return 3;
				}
			}
		}
		return 0;
	}

	@Override
	public int onePiece(int x, int y, String gender, String bodyshape, int shoulderWidth, int chestBreadth, int sleeveLength, int onePieceTotalLength) {
		System.out.println("원피스 비교");
		if(gender.equals("woman")) {
			if (bodyshape.equals("nomal")) {
				WomanNomal nomal = new WomanNomal();
				int[] size = nomal.WomanNomal(x, y);
				if (size[0] < shoulderWidth && size[1] < chestBreadth && size[3] < sleeveLength && size[10] < onePieceTotalLength) {
					//System.out.println("사이즈가 큼");
					return 1;
				} else if (size[0] <= shoulderWidth && size[1] <= chestBreadth && size[3] <= sleeveLength && size[10] <= onePieceTotalLength) {
					//System.out.println("알맞은 사이즈");
					return 2;
				} else if (size[0] > shoulderWidth || size[1] > chestBreadth || size[3] > sleeveLength || size[10] > onePieceTotalLength) {
					//System.out.println("사이즈가 작음");
					return 3;
				}
			} else if (bodyshape.equals("smallInverseTriangle")) {
				WomanSmallInverseTriangle msit = new WomanSmallInverseTriangle();
				int[] size = msit.WomanSmallInverseTriangle(x, y);
				if (size[0] < shoulderWidth && size[1] < chestBreadth && size[3] < sleeveLength && size[10] < onePieceTotalLength) {
					//System.out.println("사이즈가 큼");
					return 1;
				} else if (size[0] <= shoulderWidth && size[1] <= chestBreadth && size[3] <= sleeveLength && size[10] <= onePieceTotalLength) {
					//System.out.println("알맞은 사이즈");
					return 2;
				} else if (size[0] > shoulderWidth || size[1] > chestBreadth || size[3] > sleeveLength || size[10] > onePieceTotalLength) {
					//System.out.println("사이즈가 작음");
					return 3;
				}
			} else if (bodyshape.equals("inverseTriangle")) {
				WomanInverseTriangle mit = new WomanInverseTriangle();
				int[] size = mit.WomanInverseTriangle(x, y);
				if (size[0] < shoulderWidth && size[1] < chestBreadth && size[3] < sleeveLength && size[10] < onePieceTotalLength) {
					//System.out.println("사이즈가 큼");
					return 1;
				} else if (size[0] <= shoulderWidth && size[1] <= chestBreadth && size[3] <= sleeveLength && size[10] <= onePieceTotalLength) {
					//System.out.println("알맞은 사이즈");
					return 2;
				} else if (size[0] > shoulderWidth || size[1] > chestBreadth || size[3] > sleeveLength || size[10] > onePieceTotalLength) {
					//System.out.println("사이즈가 작음");
					return 3;
				}
			} else if (bodyshape.equals("square")) {
				WomanSquare square = new WomanSquare();
				int[] size = square.WomanSquare(x, y);
				if (size[0] < shoulderWidth && size[1] < chestBreadth && size[3] < sleeveLength && size[10] < onePieceTotalLength) {
					//System.out.println("사이즈가 큼");
					return 1;
				} else if (size[0] <= shoulderWidth && size[1] <= chestBreadth && size[3] <= sleeveLength && size[10] <= onePieceTotalLength) {
					//System.out.println("알맞은 사이즈");
					return 2;
				} else if (size[0] > shoulderWidth || size[1] > chestBreadth || size[3] > sleeveLength || size[10] > onePieceTotalLength) {
					//System.out.println("사이즈가 작음");
					return 3;
				}
			} else if (bodyshape.equals("triangle")) {
				WomanTriangle triangle = new WomanTriangle();
				int[] size = triangle.WomanTriangle(x, y);
				if (size[0] < shoulderWidth && size[1] < chestBreadth && size[3] < sleeveLength && size[10] < onePieceTotalLength) {
					//System.out.println("사이즈가 큼");
					return 1;
				} else if (size[0] <= shoulderWidth && size[1] <= chestBreadth && size[3] <= sleeveLength && size[10] <= onePieceTotalLength) {
					//System.out.println("알맞은 사이즈");
					return 2;
				} else if (size[0] > shoulderWidth || size[1] > chestBreadth || size[3] > sleeveLength || size[10] > onePieceTotalLength) {
					//System.out.println("사이즈가 작음");
					return 3;
				}
			}
		}
		return 0;
	}

}
