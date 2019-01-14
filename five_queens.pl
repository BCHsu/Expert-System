%�аO�ӦZ����m �C�@��column�u���@�ӬӦZ �qcolumn1�}�l�\��

position(1).
position(2).
position(3).
position(4).
position(5).


%�d�߻y�y
%five_queens([(1,Y1),(2,Y2),(3,Y3),(4,Y4),(5,Y5)]). 

%if reach call(P) then cut
%if call(P) fails, then goes onto the second clause instead(R).
%either P and Q ,or not P and R


if_then_else(P,Q,R):- call(P),!,Q.      
if_then_else(P,Q,R):- R.

%�b�w���ѧ�X�U�K�[�U�@row

%A���������󪺬ӦZ column   B�O�Ω󻼰j���Ѽ�(�q1�}�l)
%�p�GX�����׬�0  �Y�ثe�O�Ĥ@row �h�K�Ӧ�m�����i�H
%�_�h��X���̫�@�Ӥ���  A�ݭn�����b���Pcolumn �򤣦P�﨤�u�W �b���j�P�_�e�@��row ����first row 

safe(X,A,B):- 
    if_then_else((length(X,L),L==0),
                    (position(A)),
                    (position(A),append(_,[C],X),A=\=C,A=\=C+B,A=\=C- B,B1 is B+1,(append(_,[D],X),append(Y,[D],X)),safe(Y,A,B1))).

                  
% length(X,L) list X�����׬O�_��L

%�D�X�Ҧ��K�ӦZ���� X���{���ѽL
%Y���b�H�{�����ѽLX�W�K�[�@��column���ѽL ����񺡤K��row

%�C�@�����P�_�bX�U�i�H�񪺦�m�����X�� �M����Ƭ��C�� �̫�⥦�̥[��X�᭱

queens(X,Y):-
    if_then_else((length(X,L),L<5),
                (safe(X,A,1),append([],[A],B),append(X,B,Z),queens(Z,Y)),
                (append(X,[],Y))).

five_queens([(_,Y1),(_,Y2),(_,Y3),(_,Y4),(_,Y5)]):-
    queens([],X),
    append([],[Y1,Y2,Y3,Y4,Y5],X).


