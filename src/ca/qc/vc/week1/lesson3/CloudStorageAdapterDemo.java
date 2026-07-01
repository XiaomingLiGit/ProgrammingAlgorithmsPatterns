package ca.qc.vc.week1.lesson3;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

// ==================================================
// Target interface:
// The interface expected by our application.
// ==================================================
interface StorageService {
    void upload(String key, byte[] data);

    byte[] download(String key);

    boolean delete(String key);
}

// ==================================================
// Adaptee 1: Simulated Amazon S3 SDK
// Uses bucket + object key.
// ==================================================
class S3Sdk {
    private final Map<String, byte[]> objects = new HashMap<>();

    public void putObject(String bucket, String objectKey, byte[] content) {
        String fullKey = bucket + "/" + objectKey;
        objects.put(fullKey, content);

        System.out.println("S3 SDK: uploaded " + fullKey);
    }

    public byte[] getObject(String bucket, String objectKey) {
        String fullKey = bucket + "/" + objectKey;

        System.out.println("S3 SDK: downloading " + fullKey);
        return objects.get(fullKey);
    }

    public void deleteObject(String bucket, String objectKey) {
        String fullKey = bucket + "/" + objectKey;
        objects.remove(fullKey);

        System.out.println("S3 SDK: deleted " + fullKey);
    }
}

// Adapter for Amazon S3
class S3StorageAdapter implements StorageService {
    private final S3Sdk s3Sdk;
    private final String bucket;

    public S3StorageAdapter(S3Sdk s3Sdk, String bucket) {
        this.s3Sdk = s3Sdk;
        this.bucket = bucket;
    }

    @Override
    public void upload(String key, byte[] data) {
        s3Sdk.putObject(bucket, key, data);
    }

    @Override
    public byte[] download(String key) {
        return s3Sdk.getObject(bucket, key);
    }

    @Override
    public boolean delete(String key) {
        s3Sdk.deleteObject(bucket, key);
        return true;
    }
}

// ==================================================
// Adaptee 2: Simulated Azure Blob Storage SDK
// Uses container + blob name.
// ==================================================
class AzureBlobSdk {
    private final Map<String, byte[]> blobs = new HashMap<>();

    public void uploadBlob(String container, String blobName, byte[] bytes) {
        String fullName = container + "/" + blobName;
        blobs.put(fullName, bytes);

        System.out.println("Azure Blob SDK: uploaded " + fullName);
    }

    public byte[] downloadBlob(String container, String blobName) {
        String fullName = container + "/" + blobName;

        System.out.println("Azure Blob SDK: downloading " + fullName);
        return blobs.get(fullName);
    }

    public boolean removeBlob(String container, String blobName) {
        String fullName = container + "/" + blobName;

        System.out.println("Azure Blob SDK: deleted " + fullName);
        return blobs.remove(fullName) != null;
    }
}

// Adapter for Azure Blob Storage
class AzureBlobStorageAdapter implements StorageService {
    private final AzureBlobSdk azureSdk;
    private final String container;

    public AzureBlobStorageAdapter(AzureBlobSdk azureSdk, String container) {
        this.azureSdk = azureSdk;
        this.container = container;
    }

    @Override
    public void upload(String key, byte[] data) {
        azureSdk.uploadBlob(container, key, data);
    }

    @Override
    public byte[] download(String key) {
        return azureSdk.downloadBlob(container, key);
    }

    @Override
    public boolean delete(String key) {
        return azureSdk.removeBlob(container, key);
    }
}

// ==================================================
// Adaptee 3: Simulated Google Cloud Storage SDK
// Uses create/read/delete methods.
// ==================================================
class GoogleCloudStorageSdk {
    private final Map<String, byte[]> files = new HashMap<>();

    public void create(String bucketName, String fileName, byte[] content) {
        String fullName = bucketName + "/" + fileName;
        files.put(fullName, content);

        System.out.println("Google Cloud Storage SDK: created " + fullName);
    }

    public byte[] read(String bucketName, String fileName) {
        String fullName = bucketName + "/" + fileName;

        System.out.println("Google Cloud Storage SDK: reading " + fullName);
        return files.get(fullName);
    }

    public void remove(String bucketName, String fileName) {
        String fullName = bucketName + "/" + fileName;
        files.remove(fullName);

        System.out.println("Google Cloud Storage SDK: removed " + fullName);
    }
}

// Adapter for Google Cloud Storage
class GoogleCloudStorageAdapter implements StorageService {
    private final GoogleCloudStorageSdk googleSdk;
    private final String bucket;

    public GoogleCloudStorageAdapter(
            GoogleCloudStorageSdk googleSdk,
            String bucket
    ) {
        this.googleSdk = googleSdk;
        this.bucket = bucket;
    }

    @Override
    public void upload(String key, byte[] data) {
        googleSdk.create(bucket, key, data);
    }

    @Override
    public byte[] download(String key) {
        return googleSdk.read(bucket, key);
    }

    @Override
    public boolean delete(String key) {
        googleSdk.remove(bucket, key);
        return true;
    }
}

// ==================================================
// Adaptee 4: Local file system
// Uses Path and Files, not cloud-style APIs.
// ==================================================
class LocalFileStorageAdapter implements StorageService {
    private final Path rootDirectory;

    public LocalFileStorageAdapter(String rootDirectory) {
        this.rootDirectory = Paths.get(rootDirectory);
    }

    @Override
    public void upload(String key, byte[] data) {
        try {
            Path filePath = rootDirectory.resolve(key);

            if (filePath.getParent() != null) {
                Files.createDirectories(filePath.getParent());
            }

            Files.write(filePath, data);

            System.out.println("Local File System: saved " + filePath);
        } catch (IOException e) {
            throw new RuntimeException("Could not save file: " + key, e);
        }
    }

    @Override
    public byte[] download(String key) {
        try {
            Path filePath = rootDirectory.resolve(key);

            System.out.println("Local File System: reading " + filePath);
            return Files.readAllBytes(filePath);
        } catch (IOException e) {
            throw new RuntimeException("Could not read file: " + key, e);
        }
    }

    @Override
    public boolean delete(String key) {
        try {
            Path filePath = rootDirectory.resolve(key);

            System.out.println("Local File System: deleting " + filePath);
            return Files.deleteIfExists(filePath);
        } catch (IOException e) {
            throw new RuntimeException("Could not delete file: " + key, e);
        }
    }
}

// ==================================================
// Client class:
// Depends only on StorageService, not on a cloud vendor.
// ==================================================
class DocumentService {
    private final StorageService storageService;

    public DocumentService(StorageService storageService) {
        this.storageService = storageService;
    }

    public void saveDocument(String fileName, String content) {
        storageService.upload(fileName, content.getBytes());
    }

    public void showDocument(String fileName) {
        byte[] data = storageService.download(fileName);

        if (data == null) {
            System.out.println("Document not found: " + fileName);
            return;
        }

        System.out.println("Document content: " + new String(data));
    }

    public void removeDocument(String fileName) {
        boolean deleted = storageService.delete(fileName);
        System.out.println("Deleted successfully? " + deleted);
    }
}

// ==================================================
// Demo
// ==================================================
public class CloudStorageAdapterDemo {

    public static void main(String[] args) {
        String fileName = "reports/week1.txt";
        String content = "Adapter Pattern makes cloud providers interchangeable.";

        // Choose one storage provider:

        StorageService storageService =
                new S3StorageAdapter(new S3Sdk(), "course-bucket");

        // StorageService storageService =
        //         new AzureBlobStorageAdapter(
        //                 new AzureBlobSdk(),
        //                 "course-container"
        //         );

        // StorageService storageService =
        //         new GoogleCloudStorageAdapter(
        //                 new GoogleCloudStorageSdk(),
        //                 "course-bucket"
        //         );

        // StorageService storageService =
        //         new LocalFileStorageAdapter("local-storage");

        DocumentService documentService =
                new DocumentService(storageService);

        documentService.saveDocument(fileName, content);
        documentService.showDocument(fileName);
        documentService.removeDocument(fileName);
    }
}