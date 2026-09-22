int compare(const void* a,const void* b){
    int* p1=*(int**)a;
    int* p2=*(int**)b;
    if(p1[1]<p2[1]) return -1;
    if(p1[1]>p2[1]) return 1;
    return 0;
}
int findMinArrowShots(int** points,int pointsSize,int* pointsColSize){
    if(pointsSize==0) return 0;
    qsort(points,pointsSize,sizeof(int*),compare);
    int arrows=1;
    int arrowPos=points[0][1];
    for(int i=1;i<pointsSize;i++){
        if(points[i][0]>arrowPos){
            arrows++;
            arrowPos=points[i][1];
        }
    }
    return arrows;
}