#include <stdio.h>
#include <stdlib.h>

int main(void) {
  int *p, min, max, size, i;

  scanf("%d", &size);

  p = calloc(size, sizeof(int));

  for(i = 0; i < size; i++){
    scanf("%d", &p[i]);
  }

  min = p[0];
  max = p[0];

  for(i = 0; i < size; i++){
    if(min > p[i])
      min = p[i];
    if(max < p[i])
      max = p[i];
  }

  printf("%d %d", min, max);
  return 0;
  
}