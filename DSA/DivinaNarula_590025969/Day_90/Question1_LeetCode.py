# Minimum Number of Arrows to Burst Balloons

class Solution(object):
    def findMinArrowShots(self, points):
        """
        :type points: List[List[int]]
        :rtype: int
        """
        points.sort(key=lambda x: x[1])

        arrows = 1
        arrow_position = points[0][1]

        for start, end in points[1:]:
            if start > arrow_position:
                arrows += 1
                arrow_position = end

        return arrows