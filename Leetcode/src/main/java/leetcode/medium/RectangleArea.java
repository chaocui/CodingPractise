package leetcode.medium;

public class RectangleArea {

	public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
		//First 4 line are determine the intersections of two rectangular
		
		//Basic idea, 
		//if they intersect, bigger value of left will be the left position.
		//if they intersect, smaller value of right will be the right position.
		//if they intersect, right need to be greater than left.
		//So if left > right. right will be = left. then right - left is 0, means no intersection.
		
		//Same logic for vertical positions.
		int left = Math.max(A,E);
		int right = Math.max(Math.min(C,G), left);
		int bottom = Math.max(B,F);
		int top = Math.max(Math.min(D,H), bottom);
		
		return (C-A)*(D-B)+(G-E)*(H-F)-(top-bottom)*(right-left);
    }
	
}
