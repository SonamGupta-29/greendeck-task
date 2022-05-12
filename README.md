# greendeck-task

1.  springboot used
2.  database- sql 
3.  REST API
4.  POST

This is my post request for registration end point and user is my end point

The heirarchy of springboot is controller-service-serviceImpl
we need to some notation compulsory
ex- @RestController,@Component,@Repository etc.

 @PostMapping("user")  //end point of registration
    public String userData(@RequestBody UserDetails userDetails) {

        return userService.userDetail(userDetails); //userService reference name of service and userDetail is the method name
    }
    
    In dto we declare the fields which is taken in sql
     private String name;
    private String mob_num;
    private String dob;
    private String email;
    private String password;
    
    
   In entity first we need anotation @Entity and i take table column name and declare field with access modifier and datatype
   because i take manually table so i need to take table column
   
   @Id
    @GeneratedValue(strategy =  GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "mob_num")
    private String mobNum;

    @Column(name = "dob")
    private String dob;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;
    
    In serviceImpl we set and get the value by making entity object and save the reference object and it return account created successfully
     User user = new User();

        user.setName(userDetails.getName());
        user.setMobNum(userDetails.getMob_num());
        user.setDob(userDetails.getDob());
        user.setEmail(userDetails.getEmail());
        user.setPassword(userDetails.getPassword());

        userDAO.save(user);
        return "Account Created Successfully";
        
    



This is my post request for login end point and login is my end point

For login I make one dto which is LoginDetails, here i declare the fields eith access modifier and datatype

private String email;
    private String password;
    
    and next in DAO i write the query for fetch the email and password
   @Query(value = "select * from user where email=?1 and password=?2", nativeQuery = true)
    User findBy(String email , String password);
    
    
    and atlast we implement in serviceImpl and i used optional object which is used to represent null with absent value.
    
    optional<User> user = Optional.ofNullable(userDAO.findBy(loginDetails.getEmail(), loginDetails.getPassword())); //User is my entity
        BaseResponse baseResponse = new BaseResponse();  //BaseResponse is my DTO 
        if (!user.isPresent()) {  //if user is not present then user not found and if present then successfully login
            baseResponse.setMessage("User Not Found");
            baseResponse.setHttpStatus(HttpStatus.NOT_FOUND);
            baseResponse.setHttpStatusCode(HttpStatus.NOT_FOUND.value());
            return new ResponseEntity<BaseResponse>(baseResponse, HttpStatus.NOT_FOUND);
        }
        baseResponse.setMessage("Successfully Login");
        baseResponse.setHttpStatus(HttpStatus.OK);
        baseResponse.setHttpStatusCode(HttpStatus.OK.value());
        baseResponse.setResponse(user);
        return new ResponseEntity<BaseResponse>(baseResponse, HttpStatus.OK);
        
        
        
        Today I write Get Request for image
        
        //This is my Get request
         @GetMapping("user-img-fetch") //end point  
        public ResponseEntity<BaseResponse> userImage(){

        return userService.getUserImage();
    }
    
    In DTO i have to write the List where fetch th another DTO 
    
     private List<UserDetails> userDetails;
     
     In another DTO i gave one field
      private String SocialLogoImage;
      
      In entity I gave the column name which is in SQL table also
       @Column(name = "social_logo_img")
    private String SocialLogoImage;
    
    In DAO i have to writeQuery
    @Query(value = "SELECT * FROM user" , nativeQuery = true)  //user is my table name
    List<User> userList();
      
    In ServiceImpl i set and get the image path and also give some message
    
    BaseResponse baseResponse = new BaseResponse();
        UserDetailResponse userDetailResponse = new UserDetailResponse();
        List<User> userList = userDAO.userList();
        List<UserDetails> userDetails = new ArrayList<>();
        for (User user : userList) {
            UserDetails userDetail = new UserDetails();
            userDetail.setSocialLogoImage(user.getSocialLogoImage());


            userDetails.add(userDetail);
        }
        userDetailResponse.setUserDetails(userDetails);
        baseResponse.setMessage("image successfully fetched");
        baseResponse.setHttpStatus(HttpStatus.OK);
        baseResponse.setHttpStatusCode(HttpStatus.OK.value());

        return new ResponseEntity<>(baseResponse, HttpStatus.OK);

        
        
        
