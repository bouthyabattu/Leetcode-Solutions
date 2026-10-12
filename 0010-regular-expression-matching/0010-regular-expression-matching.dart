
class Solution {
  bool isMatch(String s, String p) {
    final m = s.length;
    final n = p.length;

    final memo = List.generate(
      m + 1,
      (_) => List<int>.filled(n + 1, -1),
    );

    bool dp(int i, int j) {
      if (memo[i][j] != -1) {
        return memo[i][j] == 1;
      }

      bool result;

      if (j == n) {
        result = i == m;
      } else {
        final firstMatch = i < m &&
            (s[i] == p[j] || p[j] == '.');

        if (j + 1 < n && p[j + 1] == '*') {
          // Match zero occurrences or consume one character
          result = dp(i, j + 2) ||
              (firstMatch && dp(i + 1, j));
        } else {
          // Match one character and advance both indices
          result = firstMatch && dp(i + 1, j + 1);
        }
      }

      memo[i][j] = result ? 1 : 0;
      return result;
    }

    return dp(0, 0);
  }
}