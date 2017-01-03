package interview_prep;

public class DivideAndConquer {
	
	float maxsum3(l, u)
	if (l > u) /* zero elements */
	return 0
	if (l == u) /* one element */
	return max(0, x[l])
	m = (l + u) / 2
	/* find max crossing to left */
	lmax = sum = 0
	for (i = m; i >= l; i--)
	sum += x[i]
	lmax = max(lmax, sum)
	/* find max crossing to right */
	rmax = sum = 0
	for i = (m, u]
	sum += x[i]
	rmax = max(rmax, sum)
	return max(lmax+rmax,
	maxsum3(l, m),
	maxsum3(m+1, u))
}
