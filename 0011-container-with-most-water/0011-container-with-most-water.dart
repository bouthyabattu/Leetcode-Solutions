
class Solution {
  int maxArea(List<int> height) {
    int left = 0;
    int right = height.length - 1;
    int maxWater = 0;

    while (left < right) {
      int width = right - left;

      int minHeight = height[left] < height[right]
          ? height[left]
          : height[right];

      int area = width * minHeight;

      if (area > maxWater) {
        maxWater = area;
      }

      // Move the pointer at the shorter line
      if (height[left] < height[right]) {
        left++;
      } else {
        right--;
      }
    }

    return maxWater;
  }
}