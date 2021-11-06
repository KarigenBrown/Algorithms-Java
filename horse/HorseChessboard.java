package horse;

import java.awt.Point;
import java.util.ArrayList;

public class HorseChessboard {

    private static int X;// ���̵�����
    private static int Y;// ���̵�����

    // ����һ������,������̵ĸ���λ���Ƿ񱻷��ʹ�
    private static boolean[] visited;

    // ʹ��һ�����Ա���Ƿ����̵�����λ�ö������ʹ���
    private static boolean finished;// ���Ϊtrue,��ʾ�ɹ�

    public static void main(String[] args) {
	// ������ʿ�����㷨�Ƿ���ȷ
	X = 8;
	Y = 8;
	int row = 1;// ������ʼλ�õ���,��1��ʼ���
	int column = 1;// ������ʼλ�õ���,��1��ʼ���

	// ��������
	int[][] chessBoard = new int[X][Y];
	visited = new boolean[X * Y];// ��ʼֵ����false

	// ����һ�º�ʱ
	long start = System.currentTimeMillis();

	traversalChessboard(chessBoard, row - 1, column - 1, 1);

	long end = System.currentTimeMillis();

	System.out.println("����ʱ: " + (end - start) + " ���� ");

	// ������̵�������
	for (int[] rows : chessBoard) {
	    for (int step : rows) {
		System.out.print(step + "\t");
	    }

	    System.out.println();
	}
    }

    /**
     * �����ʿ����������㷨
     * 
     * @param chessboard ����
     * @param row        ������ǰ��λ�õ���.��0��ʼ
     * @param column     ������ǰ��λ�õ���.��0��ʼ
     * @param step       �ǵڼ���,��ʼλ�þ��ǵ�һ��
     */
    public static void traversalChessboard(int[][] chessboard, int row, int column, int step) {
	chessboard[row][column] = step;

	// row = 4 X = 8 column = 4 = 4 * 8 + 4 = 36
	visited[row * X + column] = true;// ��Ǹ�λ���Ѿ�����

	// ��ȡ��ǰλ�ÿ����ߵ���һ��λ�õļ���
	ArrayList<Point> ps = next(new Point(column, row));

	// ����ps
	while (!ps.isEmpty()) {
	    Point p = ps.remove(0);// ȡ����һ�������ߵ�λ��

	    // �жϸõ��Ƿ��Ѿ����ʹ�
	    if (!visited[p.y * X + p.x]) {// ˵����û�з��ʹ�
		traversalChessboard(chessboard, p.y, p.x, step + 1);
	    }
	}

	// �ж������Ƿ����������,ʹ��step��Ӧ���ߵĲ����Ƚ�,
	// ���û�е�������,���ʾû���������,������������0
	// ˵��:step < X * Y ���������������
	// 1.���̵�ĿǰΪֹ,��Ȼû������
	// 2.���̴���һ�����ݹ���
	if (step < X * Y && !finished) {
	    chessboard[row][column] = 0;
	    visited[row * X + column] = false;
	} else {
	    finished = true;
	}
    }

    /**
     * ����:���ݵ�ǰλ��(Point����),����������������Щλ��(Point����),�����뵽һ��������(ArrayList),�����8��λ��
     * 
     * @param curPoint
     * @return
     */
    public static ArrayList<Point> next(Point curPoint) {
	// ����һ��ArrayList
	ArrayList<Point> ps = new ArrayList<Point>();

	// ��һ����Point
	Point p1 = new Point();

	// ��ʾ����������5���λ��
	if ((p1.x = curPoint.x - 2) >= 0 && (p1.y = curPoint.y - 1) >= 0) {
	    ps.add(new Point(p1));
	}

	// �ж������Ƿ������6���λ��
	if ((p1.x = curPoint.x - 1) >= 0 && (p1.y = curPoint.y - 2) >= 0) {
	    ps.add(new Point(p1));
	}

	// �ж������Ƿ������7���λ��
	if ((p1.x = curPoint.x + 1) < X && (p1.y = curPoint.y - 2) >= 0) {
	    ps.add(new Point(p1));
	}

	// �ж������Ƿ������0���λ��
	if ((p1.x = curPoint.x + 2) < X && (p1.y = curPoint.y - 1) >= 0) {
	    ps.add(new Point(p1));
	}

	// �ж������Ƿ������1���λ��
	if ((p1.x = curPoint.x + 2) < X && (p1.y = curPoint.y + 1) < Y) {
	    ps.add(new Point(p1));
	}

	// �ж������Ƿ������2���λ��
	if ((p1.x = curPoint.x + 1) < X && (p1.y = curPoint.y + 2) < Y) {
	    ps.add(new Point(p1));
	}

	// �ж������Ƿ������3���λ��
	if ((p1.x = curPoint.x - 1) >= 0 && (p1.y = curPoint.y + 2) < Y) {
	    ps.add(new Point(p1));
	}

	// �ж������Ƿ������4���λ��
	if ((p1.x = curPoint.x - 2) >= 0 && (p1.y = curPoint.y + 1) < Y) {
	    ps.add(new Point(p1));
	}

	return ps;
    }

}