package com.neptunes.service.graphql;

//import com.gmail.merikbest2015.ecommerce.service.PerfumeService;
//import com.gmail.merikbest2015.ecommerce.service.UserService;


//@Component
//@RequiredArgsConstructor
//public class GraphQLProvider {
//
//    private final PerfumeService perfumeService;
//    private final OrderService orderService;
//    private final UserService userService;
//
//    @Value("classpath:graphql/schemas.graphql")
//    private Resource resource;
//
//    @Getter
//    private GraphQL graphQL;
//
//    @PostConstruct
//    public void loadSchema() throws IOException {
//        File fileSchema = resource.getFile();
//        TypeDefinitionRegistry typeRegistry = new SchemaParser().parse(fileSchema);
//        RuntimeWiring wiring = buildRuntimeWiring();
//        GraphQLSchema schema = new SchemaGenerator().makeExecutableSchema(typeRegistry, wiring);
//        graphQL = GraphQL.newGraphQL(schema).build();
//    }
//
//    private RuntimeWiring buildRuntimeWiring() {
//        return RuntimeWiring.newRuntimeWiring()
//                .type("Query", typeWiring -> typeWiring
//                        .dataFetcher("perfumes", perfumeService.getAllPerfumesByQuery())
//                        .dataFetcher("perfumesIds", perfumeService.getAllPerfumesByIdsQuery())
//                        .dataFetcher("perfume", perfumeService.getPerfumeByQuery())
//                        .dataFetcher("orders", orderService.getAllOrdersByQuery())
//                        .dataFetcher("ordersByEmail", orderService.getUserOrdersByEmailQuery())
//                        .dataFetcher("users", userService.getAllUsersByQuery())
//                        .dataFetcher("user", userService.getUserByQuery()))
//                .build();
//    }
//}
