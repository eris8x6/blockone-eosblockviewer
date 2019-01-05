# blockone-eosblockviewer
Block.One Android Developer Interview Take home Test 
Task 1: Android Application to pull the most recent blocks (Chris Phelan solution)

Screen shots 1-5 are in the sampledata folder at the top level of the git repository.

Functional Criteria:

App has a button [visible in screen shot 1, immediately after starting app] which when clicked will display a list of the 20 most recent blocks [visible in screen shot 2, about 10 seconds after clicking button].  The list is scrollable, as 20 listings will not fit on the screen. Each block is denoted by its producer and timestamp (selected as the most human readable identifiers).
When user clicks on a block they should be taken to a Block Details screen; the Details screen should show a summary view of the block which contains the producer, count of transactions and the producer signature [all visible in screen shot 3].
The Details screen should have a toggle to show and hide the raw contents of the transaction [visible in screen shot 3]. Screen shots 4 and 5 show the Details screen after the toggle is moved to the "show" position and after the raw contents of the transaction are scrolled.

Technical Criteria and Info:

Application should have Unit tests: I have implemented Unit tests for only one class (BlockData). This class contains the only actual business logic in the Model (mapping the data from the Dto object provided by the Retrofit library onto the BlockModel object used by the app). I have not created Unit tests for the Json mapping (to verify the behavior of the mapping with malformed or missing server responses), because I am relatively unfamiliar with the Retrofit library and therefore don't know how to mock it properly. Also advisable would be app Integration tests (on BlockViewModel and BlockListController in particular), which can be done with MockK (I ran out of time for creating these).

The BlockListController and DataLoader use Kotlin coroutines to streamline the code for retrieving blocks from the REST API and providing them to the Model. The Model->ViewModel->View interaction could be further improved by taking advantage of more of the annotations available with the Retrofit and Moshi libraries (I'm pretty sure with some additional work the DTO layer could be entirely eliminated). Insertion of data to the Detail View is streamlined with Android data binding. I didn't do this for the List View (which has only 2 data fields for each item) - doing so would improve maintainability though it might not in this case reduce the actual amount of code.
