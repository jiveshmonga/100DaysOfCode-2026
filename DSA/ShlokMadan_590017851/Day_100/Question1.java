
class Question1
{
    public static int minEatingSpeed(int[] piles,int h)
    {
        int low=1;
        int high=0;

        for(int pile:piles)
        {
            high=Math.max(high,pile);
        }

        while(low<high)
        {
            int mid=low+(high-low)/2;
            long hours=0;

            for(int pile:piles)
            {
                hours+=(pile+mid-1)/mid;
            }

            if(hours<=h)
            {
                high=mid;
            }
            else
            {
                low=mid+1;
            }
        }

        return low;
    }

    public static void main(String[] args)
    {
        int[] piles={3,6,7,11};
        int h=8;

        System.out.println(minEatingSpeed(piles,h));
    }
}