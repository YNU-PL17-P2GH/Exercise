def find(myShortestPath)
  Integer start = myShortestPath.getStart()
  Integer goal = myShortestPath.getGoal()
  Array heap = []
  Array result = Array.new(goal + 1){Array.new(2, nil)}
  Array edge = Array.new(3)
  edge[0] = start
  edge[1] = start
  edge[2] = 0
  push(heap, edge)
  findSub(myShortestPath, heap, goal, result)
  #p result
  Integer node = goal
  Array path = []
  while node != start
    path << [result[node][0], node]
    node = result[node][0]
  end
  Integer i = path.length() - 1
  while i >= 0
    myShortestPath.selectPath(path[i][0], path[i][1])
    i = i - 1
  end
end

def findSub(myShortestPath, heap, goal, result)
  Array edge = Array.new()
  Array haveEdge = Array.new()
  Integer cost = 0
  while heap.length != 0
    edge = pop(heap)
    if result[edge[1]][0] != nil then
      next
    end
    result[edge[1]][0] = edge[0]
    result[edge[1]][1] = edge[2]
    cost = edge[2]

    if edge[1] == goal then
      return true
    end

    haveEdge = myShortestPath.getHavePath(edge[1])

    Integer i = 0
    while i < haveEdge.length
      if result[haveEdge[i][0]][0] != nil then
        i = i + 1
        next
      end
      Array newEdge = Array.new(3)
      newEdge[0] = edge[1]
      newEdge[1] = haveEdge[i][0]
      newEdge[2] = haveEdge[i][1] + cost
      push(heap, newEdge)
      i = i + 1
    end
  end
  return false
end

def push(heap, values)
  heap << values
  Integer pos = heap.length - 1

  while pos > 0
    if(heap[(pos - 1) / 2][2] <= values[2]) then
      break
    end
    Array t = heap[(pos - 1) / 2]
    heap[(pos - 1) / 2] = heap[pos]
    heap[pos] = t
    pos = (pos - 1) / 2
  end
end

def pop(heap)
  Array result = heap[0]
  heap[0] = heap[heap.length - 1]
  heap.delete_at(heap.length - 1)

  Integer pos = 0
  Integer left = 10000 #十分に大きい数字
  Integer right = 10000

  while pos < heap.length
    if pos * 2 + 1 < heap.length then
      left = heap[pos * 2 + 1][2]
    else
      left = 10000
    end
    if pos * 2 + 2 < heap.length then
      right = heap[pos * 2 + 2][2]
    else
      right = 10000
    end
    Array t = []
    if heap[pos][2] < left && heap[pos][2] < right then
      break
    end

    if left < right then
      t = heap[pos]
      heap[pos] = heap[pos * 2 + 1]
      heap[pos * 2 + 1] = t
      pos = pos * 2 + 1
    else
      t = heap[pos]
      heap[pos] = heap[pos * 2 + 2]
      heap[pos * 2 + 2] = t
      pos = pos * 2 + 2
    end
  end
  return result
end