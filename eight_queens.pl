%標記皇后的位置 每一個column只能放一個皇后 從column1開始擺放

position(1).
position(2).
position(3).
position(4).
position(5).
position(6).
position(7).
position(8).

%查詢語句
%eight_queens([(1,Y1),(2,Y2),(3,Y3),(4,Y4),(5,Y5),(6,Y6),(7,Y7),(8,Y8)]). 

%if reach call(P) then cut
%if call(P) fails, then goes onto the second clause instead(R).
%either P and Q ,or not P and R


if_then_else(P,Q,R):- call(P),!,Q.      
if_then_else(P,Q,R):- R.

%在已有棋局X下添加下一row

%A為滿足條件的皇后 column   B是用於遞迴的參數(從1開始)
%如果X的長度為0  即目前是第一row 則八個位置均都可以
%否則取X的最後一個元素  A需要滿足在不同column 跟不同對角線上 在遞迴判斷前一個row 直到first row 

safe(X,A,B):- 
    if_then_else((length(X,L),L==0),
                    (position(A)),
                    (position(A),append(_,[C],X),A=\=C,A=\=C+B,A=\=C- B,B1 is B+1,(append(_,[D],X),append(Y,[D],X)),safe(Y,A,B1))).

                  
% length(X,L) list X的長度是否為L

%求出所有八皇后的解 X為現有棋盤
%Y為在以現有的棋盤X上添加一個column的棋盤 直到填滿八個row

%每一次先判斷在X下可以放的位置有哪幾個 然後轉化為列表 最後把它們加到X後面

queens(X,Y):-
    if_then_else((length(X,L),L<8),
                (safe(X,A,1),append([],[A],B),append(X,B,Z),queens(Z,Y)),
                (append(X,[],Y))).

% X=[Y1,Y2,Y3,Y4,Y5,Y6,Y7,Y8]
eight_queens([(_,Y1),(_,Y2),(_,Y3),(_,Y4),(_,Y5),(_,Y6),(_,Y7),(_,Y8)]):-
    queens([],X),
    append([],[Y1,Y2,Y3,Y4,Y5,Y6,Y7,Y8],X).

%findall(Qs,eight_queens([(1,Y1),(2,Y2),(3,Y3),(4,Y4),(5,Y5),(6,Y6),(7,Y7),(8,Y8)]),R).


%findall([Y1,Y2,Y3,Y4,Y5,Y6,Y7,Y8],eight_queens([(1,Y1),(2,Y2),(3,Y3),(4,Y4),(5,Y5),(6,Y6),(7,Y7),(8,Y8)]),R).
% R = 所有解

%findall([Y1,Y2,Y3,Y4,Y5,Y6,Y7,Y8],eight_queens([(1,Y1),(2,Y2),(3,Y3),(4,Y4),(5,Y5),(6,Y6),(7,Y7),(8,Y8)]),R), length(R,N).
% N=所有解的個數

%findall(Y3,eight_queens([(1,3),(2,1),(3,Y3),(4,Y4),(5,Y5),(6,Y6),(7,Y7),(8,Y8)]),R).
%R = [7].
% 求Y3(第三個皇后的位置)的值 條件是第一個皇后擺在3 第二個皇后擺在1


%findall([Y2,Y3],eight_queens([(1,1),(2,Y2),(3,Y3),(4,Y4),(5,Y5),(6,Y6),(7,Y7),(8,Y8)]),R).
%R = [[5, 8], [6, 8], [7, 4], [7, 5]].
%R= 當第一個皇后擺在1時   第二個跟第三個皇后可能的位置組合