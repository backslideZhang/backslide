
public class BestTimeToBuyAndSellStockIII {
	public void solution(){
		System.out.println(""+maxProfit(new int[]{2,1,2,0,1}));
	}
	
	public int maxProfit(int[] prices) {
		if (prices == null || prices.length <= 1){
			return 0;
		}
		int[] profit1 = new int[prices.length];
		int[] profit2 = new int[prices.length];
		profit1[0] = 0;
		int minPrice = prices[0];
		for (int i = 1; i < prices.length; i++){
			minPrice = Math.min(minPrice, prices[i]);
			profit1[i] = Math.max(profit1[i-1], prices[i]-minPrice);
		}
		profit2[prices.length-1] = 0;
		int maxPrice = prices[prices.length-1];
		for (int i = prices.length-2; i >= 0; i--){
			maxPrice = Math.max(maxPrice, prices[i]);
			profit2[i] = Math.max(profit2[i+1], maxPrice-prices[i]);
		}
		int maxprofit = profit1[0]+profit2[0];
		for (int i = 1; i < prices.length; i++){
			maxprofit = Math.max(maxprofit, profit1[i]+profit2[i]);
		}
		return maxprofit;
    }
}
