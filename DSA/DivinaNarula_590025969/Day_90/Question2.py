# Video Stitching

def videoStitching(clips, time):
    clips.sort()

    clips_used = 0
    current_end = 0
    farthest_end = 0
    i = 0
    n = len(clips)

    while current_end < time:
        while i < n and clips[i][0] <= current_end:
            farthest_end = max(farthest_end, clips[i][1])
            i += 1

        if farthest_end == current_end:
            return -1

        clips_used += 1
        current_end = farthest_end

    return clips_used


n = int(input("Enter number of clips: "))
clips = []

for _ in range(n):
    start, end = map(int, input("Enter Clips: ").split())
    clips.append([start, end])

time = int(input("Enter target time: "))

print(videoStitching(clips, time))