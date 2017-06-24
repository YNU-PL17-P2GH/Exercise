def knapsack(myKnapsack)
  Integer i = 0
  Integer itemNum = myKnapsack.getItemNum()
  Array items = Array.new(itemNum){ Array.new(2) }
  while i < itemNum
    Array item = myKnapsack.getItem(i)
    items[i][0] = item[0]
    items[i][1] = item[1]
    i = i + 1
  end
  Integer capacity = myKnapsack.getCapacity()
  Array dp = Array.new(itemNum + 1){ Array.new(capacity + 1) }
  i = 0
  while i < capacity + 1
    dp[0][i] = 0
    i = i + 1
  end
  i = 0
  Integer j = 0
  #p items
  while i < itemNum
    j = 0
    while j < capacity + 1
      if items[i][0] <= j then
        if items[i][1] + dp[i][j - items[i][0]] > dp[i][j] then
          dp[i + 1][j] = items[i][1] + dp[i][j - items[i][0]]
        else
          dp[i + 1][j] = dp[i][j]
        end
      else
        dp[i + 1][j] = dp[i][j]
      end
      j = j + 1
    end
    i = i + 1
  end

  i = itemNum
  j = capacity
  while i > 0
    if dp[i][j] != dp[i - 1][j] then
      myKnapsack.pickItem(i - 1)
      #p i-1
      #p items[i - 1]
      while dp[i][j] == dp[i][j - 1]
        j = j - 1
      end
      j = j + 1 - items[i - 1][0]
    end
    i = i - 1
  end
end