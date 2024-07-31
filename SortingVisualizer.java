import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class SortingVisualizer extends JFrame {
    private final int ARRAY_SIZE = 50;
    private final int BAR_WIDTH = 10;
    private final int BAR_HEIGHT_MULTIPLIER = 10;
    private final int DELAY_MS = 50;

    private int[] array;
    private JPanel panel;

    public SortingVisualizer() {
        setTitle("Sorting Algorithm Visualizer");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 400);
        setLocationRelativeTo(null);

        panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                drawBars(g);
            }
        };
        panel.setBackground(Color.WHITE);
        add(panel, BorderLayout.CENTER);

        JPanel controlPanel = new JPanel();
        controlPanel.setLayout(new FlowLayout());

        String[] sortingAlgorithms = {"Bubble Sort", "Selection Sort", "Insertion Sort",
                "Heap Sort", "Merge Sort", "Quick Sort", "Counting Sort", "Linear Sort", "Topological Sort"};
        JComboBox<String> algorithmComboBox = new JComboBox<>(sortingAlgorithms);
        controlPanel.add(algorithmComboBox);

        JButton startButton = new JButton("Start Sorting");
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedAlgorithm = (String) algorithmComboBox.getSelectedItem();
                startSorting(selectedAlgorithm);
            }
        });
        controlPanel.add(startButton);

        add(controlPanel, BorderLayout.SOUTH);

        generateRandomArray();
        repaint();
    }

    private void drawBars(Graphics g) {
        if (array == null) {
            return;
        }

        int x = 10;
        for (int i = 0; i < array.length; i++) {
            int barHeight = array[i] * BAR_HEIGHT_MULTIPLIER;
            g.fillRect(x, panel.getHeight() - barHeight, BAR_WIDTH, barHeight);
            x += BAR_WIDTH + 5;
        }
    }

    private void generateRandomArray() {
        array = new int[ARRAY_SIZE];
        Random random = new Random();
        for (int i = 0; i < ARRAY_SIZE; i++) {
            array[i] = random.nextInt(ARRAY_SIZE) + 1;
        }
    }

    private void startSorting(String selectedAlgorithm) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                switch (selectedAlgorithm) {
                    case "Bubble Sort":
                        bubbleSort();
                        break;
                    case "Selection Sort":
                        selectionSort();
                        break;
                    case "Insertion Sort":
                        insertionSort();
                        break;
                    case "Heap Sort":
                        heapSort();
                        break;
                    case "Merge Sort":
                        mergeSort(0, array.length - 1);
                        break;
                    case "Quick Sort":
                        quickSort(0, array.length - 1);
                        break;
                    case "Counting Sort":
                        countingSort();
                        break;
                    case "Linear Sort":
                        linearSort();
                        break;
                    default:
                        break;
                }
            }
        }).start();
    }

    private void swap(int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    private void sleep(int delay) {
        try {
            Thread.sleep(delay);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void bubbleSort() {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    swap(j, j + 1);
                    repaint();
                    sleep(DELAY_MS);
                }
            }
        }
    }

    private void selectionSort() {
        for (int i = 0; i < array.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }
            swap(i, minIndex);
            repaint();
            sleep(DELAY_MS);
        }
    }

    private void insertionSort() {
        for (int i = 1; i < array.length; i++) {
            int key = array[i];
            int j = i - 1;
            while (j >= 0 && array[j] > key) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = key;
            repaint();
            sleep(DELAY_MS);
        }
    }

    private void heapify(int n, int i) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < n && array[left] > array[largest]) {
            largest = left;
        }

        if (right < n && array[right] > array[largest]) {
            largest = right;
        }

        if (largest != i) {
            swap(i, largest);
            repaint();
            sleep(DELAY_MS);

            heapify(n, largest);
        }
    }

    private void heapSort() {
        for (int i = array.length / 2 - 1; i >= 0; i--) {
            heapify(array.length, i);
        }

        for (int i = array.length - 1; i >= 0; i--) {
            swap(0, i);
            repaint();
            sleep(DELAY_MS);

            heapify(i, 0);
        }
    }

    private void merge(int l, int m, int r) {
        int n1 = m - l + 1;
        int n2 = r - m;

        int[] leftArray = new int[n1];
        int[] rightArray = new int[n2];

        for (int i = 0; i < n1; ++i) {
            leftArray[i] = array[l + i];
        }

        for (int j = 0; j < n2; ++j) {
            rightArray[j] = array[m + 1 + j];
        }

        int i = 0, j = 0;
        int k = l;

        while (i < n1 && j < n2) {
            if (leftArray[i] <= rightArray[j]) {
                array[k] = leftArray[i];
                i++;
            } else {
                array[k] = rightArray[j];
                j++;
            }
            k++;
            repaint();
            sleep(DELAY_MS);
        }

        while (i < n1) {
            array[k] = leftArray[i];
            i++;
            k++;
            repaint();
            sleep(DELAY_MS);
        }

        while (j < n2) {
            array[k] = rightArray[j];
            j++;
            k++;
            repaint();
            sleep(DELAY_MS);
        }
    }

    private void mergeSort(int l, int r) {
        if (l < r) {
            int m = l + (r - l) / 2;

            mergeSort(l, m);
            mergeSort(m + 1, r);

            merge(l, m, r);
        }
    }

    private int partition(int low, int high) {
        int pivot = array[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (array[j] < pivot) {
                i++;
                swap(i, j);
                repaint();
                sleep(DELAY_MS);
            }
        }
        swap(i + 1, high);
        repaint();
        sleep(DELAY_MS);
        return i + 1;
    }

    private void quickSort(int low, int high) {
        if (low < high) {
            int pi = partition(low, high);
            quickSort(low, pi - 1);
            quickSort(pi + 1, high);
        }
    }

    private void countingSort() {
        int[] output = new int[array.length];
        int[] count = new int[ARRAY_SIZE + 1];

        for (int num : array) {
            count[num]++;
        }

        for (int i = 1; i <= ARRAY_SIZE; i++) {
            count[i] += count[i - 1];
        }

        for (int i = array.length - 1; i >= 0; i--) {
            output[count[array[i]] - 1] = array[i];
            count[array[i]]--;
        }

        System.arraycopy(output, 0, array, 0, array.length);
        repaint();
        sleep(DELAY_MS);
    }

    private void linearSort() {
        int max = array[0];
        for (int num : array) {
            if (num > max) {
                max = num;
            }
        }

        int[] count = new int[max + 1];
        for (int num : array) {
            count[num]++;
        }

        int index = 0;
        for (int i = 0; i < count.length; i++) {
            while (count[i] > 0) {
                array[index] = i;
                index++;
                count[i]--;
                repaint();
                sleep(DELAY_MS);
            }
        }
    }

    // Implement topologicalSort() method (assuming you have a graph representation)

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            SortingVisualizer visualizer = new SortingVisualizer();
            visualizer.setVisible(true);
        });
    }
}
