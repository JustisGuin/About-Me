
'''word='baugette'.upper()
wordReverser=word[::-1] #This is reversing the word
row="Y\tI\tT\tA\tL\tI\tA\tN\tQ\tX"
row=row.replace("\t","")    #This is replacing the row with a blank space 
#print(row)
#if word in row or wordReverser in row:
#    print("in row #")
'''
filename="WordSearch_random.txt"
file= open(filename,"r")

'''for row in file:
    print(row)
    row=row.replace("\t","")
    print(row)'''

filename="WordSearch_random.txt"
file= open(filename,"r")
board=[]
verticalBoard=[]


#reads board and adds line to board 
for line in file:
    #rstrip to remove to \n and split the line to the \t
    board.append(line.rstrip().replace("\t",""))
file.close()
for c in range(len(board[0])):
    line=''
    for r in range(len(board)):
        line+=board[r][c]
    verticalBoard.append(line)

file.close()


filename="WordSearch_random.txt"
file= open(filename,"r")
board=[]
diagonalList=[]
for line in file:
    board.append(line.rstrip().replace("\t",""))
file.close()
for c in range(len(board[0])):
    line=''
    for r in range(len(board)):
        r+=1
        c+=1
    if r>=len(board) or c>=len(board[0]):      
        r=","
        c=","  
        break
    diagonalList.append(line)



def diagonalLooker(w,b,d):        
    wordReverser=w[::-1]
    for row in range(len(b)):
        if w in b[row]:
            #finding italian in board[row],returns the int that the col is 
            col = b[row].index(w)
            if d =="r":
                print(f"{w} is in row: {row} and column: {col}")
            elif d =="v":
                print(f"{w} is in row: {col} and column: {row}")
        elif wordReverser in b[row]:
            col = b[row].index(wordReverser)
            if d =="r":
                print(f"{w} is in row: {row} and column: {col}")
            elif d =="d":
                print(f"{w} is in row: {col} and column: {row}")
word=input("Give me a word to search: ").upper()
diagonalLooker(word,board,"r")
diagonalLooker(word,diagonalList,"d")
'''

def horizonalLooker(w,b,d):        
    wordReverser=w[::-1]
    for row in range(len(b)):
        if w in b[row]:
            #finding italian in board[row],returns the int that the col is 
            col = b[row].index(w)
            if d =="r":
                print(f"{w} is in row: {row} and column: {col}")
            elif d =="v":
                print(f"{w} is in row: {col} and column: {row}")
        elif wordReverser in b[row]:
            col = b[row].index(wordReverser)
            if d =="r":
                print(f"{w} is in row: {row} and column: {col}")
            elif d =="v":
                print(f"{w} is in row: {col} and column: {row}")
word=input("Give me a word to search: ").upper()
horizonalLooker(word,board,"r")
horizonalLooker(word,verticalBoard,"v")

'''






'''
#print(board)
for r in range(len(board)):
    for c in range(len(board[0])):
        print(board[r][c],end="")
    print()
print("\n"*3)
#rotate the board 90 degrees
for c in range(len(board[0])):
    for r in range(len(board)):
        print(board[r][c],end="")
    print()
    
for r in range(len(board)):
    for c in range(len(board[0])):
        #print(str(r)+str(c),end=" ")
        print(board[r][c],end=" ")
        r+=1
        c+=1
        if r>=(len(board)) or (c>=len(board[0])):
            break
    print()
    # break
print("\n"*3)
out=""
diagonalboard=[]
for c in range(len(board[0])):
    for r in range(len(board)):
        #print(str(r)+str(c),end=" ")
        print(board[r][c],end=" ")
        out+=board[r][c]
        r+=1
        c+=1
        if r>=(len(board)) or (c>=len(board[0])):
            diagonalboard.append(out)
            out=""
            break
    print()
    # break
print(diagonalboard)'''