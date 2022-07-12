package com.grpcstarter.grpc.service;

import com.grpcstarter.grpc.GreetingRequest;
import com.grpcstarter.grpc.GreetingResponse;
import com.grpcstarter.grpc.GreetingServiceGrpc;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;


@GrpcService
public class GreetingServiceImpl extends GreetingServiceGrpc.GreetingServiceImplBase {


    @Override
    public void greeting(GreetingRequest request, StreamObserver<GreetingResponse> responseObserver) {
        String message  = request.getMessage();
        System.out.println(message);
       GreetingResponse gr = GreetingResponse.newBuilder().setMessage("ge got the message: "+message).build();

        responseObserver.onNext(gr);
        responseObserver.onCompleted();
    }
}