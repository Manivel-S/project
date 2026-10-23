import { test, expect } from '@playwright/test';

test(
  'useModuleTwo',
  {
    annotation: { type: 'QADENCE_TC_ID', description: 'TC-004' },
    tag: ['@QADENCE_TC_ID:TC-004'],
  },
  async ({ page }) => {


    await test.step('#01 - Click on the first inventory item description (index 0)', async () => {
      await page.locator('[data-test="inventory-item-description"]').locator('[data-test="inventory-item-desc"]').nth(0).click();
    });

    await test.step('#02 - Click on the second inventory item description (index 1)', async () => {
      await page.locator('[data-test="inventory-item-description"]').locator('[data-test="inventory-item-desc"]').nth(1).click();
    });

    await test.step('#03 - Click on the third inventory item description (index 2)', async () => {
      await page.locator('[data-test="inventory-item-description"]').locator('[data-test="inventory-item-desc"]').nth(2).click();
    });

    await test.step('#04 - Click on the fourth inventory item description (index 3)', async () => {
      await page.locator('[data-test="inventory-item-description"]').locator('[data-test="inventory-item-desc"]').nth(3).click();
    });

    await test.step('#05 - Click on the fifth inventory item description (index 4)', async () => {
      await page.locator('[data-test="inventory-item-description"]').locator('[data-test="inventory-item-desc"]').nth(4).click();
    });

    await test.step('#06 - Click on the sixth inventory item description (index 5)', async () => {
      await page.locator('[data-test="inventory-item-description"]').locator('[data-test="inventory-item-desc"]').nth(5).click();
    });
    //Start - Module - logout module

    await test.step('#07 - Click on the main section containing \'LoginAccepted usernames\' text', async () => {
      await page.getByRole("main").filter({ hasText: "LoginAccepted usernames" }).click();
    });

    await test.step('#08 - Click the Logout button', async () => {
      await page.getByRole("button", { name: "Logout", exact: true }).click();
    });

    await test.step('#09 - Click the Open Menu button', async () => {
      await page.getByRole("button", { name: "Open Menu", exact: true }).click();
    });
    //End - Module - logout module

  }
);

