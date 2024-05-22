package com.neptunes.security;

//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.context.SecurityContextHolder;


//@Component
//@RequiredArgsConstructor
//public class JwtFilter extends GenericFilterBean {
//
//    private final JwtProvider jwtProvider;
//
//    @Override
//    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
//        String token = jwtProvider.resolveToken((HttpServletRequest) servletRequest);
//
//        try {
//            if (token != null && jwtProvider.validateToken(token)) {
//                Authentication authentication = jwtProvider.getAuthentication(token);
//
//                if (authentication != null) {
//                    SecurityContextHolder.getContext().setAuthentication(authentication);
//                }
//            }
//        } catch (JwtAuthenticationException e) {
//            SecurityContextHolder.clearContext();
//            ((HttpServletResponse) servletResponse).sendError(e.getHttpStatus().value());
//            throw new JwtAuthenticationException(INVALID_JWT_TOKEN);
//        }
//        filterChain.doFilter(servletRequest, servletResponse);
//    }
//}
