#include <stdio.h>
#include <stdlib.h>
int compare(const void* a,const void* b){
    int* p1=*(int**)a;
    int* p2=*(int**)b;
    if(p1[0]<p2[0]) return -1;
    if(p1[0]>p2[0]) return 1;
    return 0;
}
int videoStitching(int** clips,int clipsSize,int time){
    qsort(clips,clipsSize,sizeof(int*),compare);
    int count=0;
    int current=0;
    int farthest=0;
    int i=0;
    while(current<time){
        while(i<clipsSize && clips[i][0]<=current){
            if(clips[i][1]>farthest)
                farthest=clips[i][1];
            i++;
        }
        if(farthest==current)
            return -1;
        count++;
        current=farthest;
    }
    return count;
}