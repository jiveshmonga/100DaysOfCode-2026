class Solution(object):
    def videoStitching(self, clips, time):
        clips.sort()

        count = 0
        current = 0
        i = 0

        while current < time:
            farthest = current

            while i < len(clips) and clips[i][0] <= current:
                farthest = max(farthest, clips[i][1])
                i += 1

            if farthest == current:
                return -1

            count += 1
            current = farthest

        return count