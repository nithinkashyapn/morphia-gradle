package in.nithin.model;

import org.bson.types.ObjectId;
import org.glassfish.jersey.linking.InjectLink;
import org.glassfish.jersey.linking.InjectLinks;
import org.mongodb.morphia.annotations.Embedded;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;
import org.mongodb.morphia.annotations.Reference;

@Entity("caesar")
public class Caesar {

    public String message;
    public int offset;

    public Caesar(){}

    public Caesar(String message, int offset) {
        this.message = message;
        this.offset = offset;
    }

    // Constructor
    public Caesar(Caesar caesar){
        this.message = caesar.message;
        this.offset = caesar.offset;
    }

}
