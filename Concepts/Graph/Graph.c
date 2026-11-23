#include <stdio.h>

int graph[3][3] = {
    {0, 1, 0},
    {1, 0, 1},
    {0, 1, 0}};

void main()
{
    for (int i = 0; i < 3; i++)
    {
        for (int j = 0; j < 3; j++)
        {
            if (graph[i][j] == 1)
            {
                printf("%d -> %d", i, j);
                printf("\n");
            }
        }
    }
}